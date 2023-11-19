/*
Cada cliente puede tener a lo sumo 5 alquileres con 
importe mayor a $25000 cada uno en un mismo año (considerando
la fecha de inicio del alquiler)
*/

create or replace function check_maximo_5_mayor_25000()
returns trigger as $$
begin 
	if((exists(
		select 1
		from alquiler al
		where al.importe_total > 25000
		and al.id_cliente = new.id_cliente
		group by al.id_cliente,extract(year from al.fecha_desde)
		having count(al.id_alquiler) > 5
	)) = TRUE) then
		raise exception 'El cliente ya tiene 5 alquileres que superan los 25000 este año';
	end if;
	return new;
end;  $$ language 'plpgsql';


create or replace trigger tr_maximo_5_mayor_25000
after insert or update 
on alquiler
for each row execute procedure check_maximo_5_mayor_25000();

select * from alquiler;
update alquiler set id_cliente = 1;

--Ahora todos los alquileres son del cliente 1 y con importe_total mayor a 30000
--Pero podemos ver que no hay mas de 5 con fecha_desde en el mismo año


update alquiler set fecha_desde = '2025-01-01' where id_alquiler = 24;

--Cuando queremos ejecutar nos arroja la exception por lo que el trigger funciona correctamente
update alquiler set fecha_desde = '2025-01-01' where id_alquiler = 23;

--Este lo inserta ya que si bien posee mas de 5 alquileres en el año 2025, este
--ultimo no supera los 25000 de importe_total
insert into alquiler values (1,1,'2025-06-06','2025-08-08',10000);


--Esta consulta nos tira la exception
insert into alquiler values (2,1,'2025-06-06','2025-08-08',100000);



/*
Para los tipos de alojamiento de menos de 50 metros cuadradoos
se debe registrar el costo maximo por dia
*/

alter table tipo_alojamiento 
add constraint check_costo_maximo
check(
	(superf_max >= 50) or
	(superf_max < 50 and costo_diario_max is not null)
);

select * from tipo_alojamiento ta;

--No deja insertar la nueva tupla ya que la suerficio es
--menor a 50 y no se le registro el costo diario maximo
insert into tipo_alojamiento values 
(21,'Bosque',20,null);


/*
El costo diario de cada alojamiento debe ser menor o igual
que el costo diario maximo del de su tipo de alojamiento

*/


select a.costo_diario,ta.costo_diario_max
from alojamiento a
inner join tipo_alojamiento ta 
on ta.id_alojamiento = a.id_alojamiento;


drop function checkear_costos;

create or replace function fn_checkear_costos()
returns trigger as $$
declare 
	costo_diario_maximo integer;
	costo_diario_fn integer;
begin 
	select costo_diario_max 
	into costo_diario_maximo
	from tipo_alojamiento
	where id_alojamiento = new.id_alojamiento;

	select costo_diario
	into costo_diario_fn
	from alojamiento
	where nro_aloj = new.nro_aloj and 
	id_alojamiento = new.id_alojamiento;

	if (costo_diario_fn > costo_diario_maximo) then
		raise exception 'El costo diario del alojamiento 
						no puede superar al costo diario
						maximo del tipo de alojamiento';
	end if;

	return new;	
end; $$ language 'plpgsql';

create or replace trigger tg_checkear_costos
after insert or update 
on alojamiento
for each row execute function fn_checkear_costos();


select * from alojamiento;

--Arroja la exception ya que 200(costo diario)
--es mayor a 150(costo diario maximo del tipo de almacenamiento)
update alojamiento 
set costo_diario = 200 
where nro_aloj = 1 and id_alojamiento = 1;