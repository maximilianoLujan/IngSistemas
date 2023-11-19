/*
Datos de los alojamientos que no han registrado alquileres
durante el corriente año
*/

--Para que la vista sea automaticamente actualizable 
--no puede haber ningun join
create or replace view view_alojamientos_sin_alquiler as
select *
from alojamiento a2
where (a2.nro_aloj,a2.id_alojamiento) not in (
	select aa.nro_aloj,aa.id_alojamiento
	from alquiler_aloj aa
	where aa.id_alquiler not in (
		select a.id_alquiler 
		from alquiler a 
		where extract(year from a.fecha_desde) = extract(year from current_date)
		or extract(year from a.fecha_hasta) = extract(year from current_date)
	)
);


--Esta consulta actualiza la vista y la propaga a la tabla original
update view_alojamientos_sin_alquiler 
set ubicacion = 'Lejos'
where nro_aloj = 5 and id_alojamiento = 1;

select * from view_alojamientos_sin_alquiler;
select * from alojamiento a;


/*
Por cada alquiler iniciado en los ultimos tres meses,
el importe total del mismo y la cantidad de alojamientos
que abarca
*/

--Al pedir por cantidad si o si se debe usar una funcion
--de agregacion COUNT() por lo que la vista no es 
--automaticamente actualizable
create or replace view view_importe_alojamientos_ultimos_alquileres as
select a.id_alquiler,a.importe_total,count(aa.nro_aloj)
from alquiler a
left join alquiler_aloj aa 
on a.id_alquiler = aa.id_alquiler
WHERE a.fecha_desde between 
CURRENT_DATE - INTERVAL '3 months' and current_date
group by a.id_alquiler,a.importe_total;


select * from view_importe_alojamientos_ultimos_alquileres;





/*
Identificador, nombre y apellido de los 10 clientes que
mas alquileres han realizado
*/

--Nuevamente, debemos hacer un count para 
--saber cuantos alquileres realizo un cliente
drop view view_clientes_con_mas_alquileres;
create or replace view view_clientes_con_mas_alquileres as
select c.id_cliente,c.nombre,c.apellido,count(a.id_alquiler) as cantidad_alquileres
from cliente c
left join alquiler a
on a.id_cliente = c.id_cliente
group by c.id_cliente,c.nombre,c.apellido
order by count(a.id_alquiler) desc
limit 10;


select * from view_clientes_con_mas_alquileres;