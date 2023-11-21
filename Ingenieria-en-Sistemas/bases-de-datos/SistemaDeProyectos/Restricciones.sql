/*
Los proyectos sin fecha de finalizacion asignada no deben
superar 100000 de presupuesto
*/

alter table proyecto 
add constraint check_presupuesto
check(
	(fecha_fin is null and presupuesto  <= 100000) or
	(fecha_fin is not null)
);

select * from sector;

--Deja insertar esta tupla ya que el presupuesto es menor 
--que 100000
insert into proyecto values 
	(10,10,'Proyecto amiental',40000,'2023-01-10',null,4);

--No deja insertar esta tupla ya que la fecha de finalizacion
--es null y el presupuesto supera los 100000
insert into proyecto values 
	(9,10,'Proyecto De Salud',150000,'2023-01-10',null,4);


/*
El director asignado de un proyecto debe haber trabajado
al menos en 5 proyectos ya finalizados en el mismo sector
*/






/*
En cada proyecto pueden trabajar 10 ingenieros como maximo
*/

create or replace function fn_maximo_10_ingenieros()
returns trigger as $$ 
declare 
	cantidad_trabajando integer;
begin
	select count(t.id_ingeniero)
	into cantidad_trabajando
	from trabaja t 
	where t.id_sector = new.id_sector and 
	t.nro_proyecto = new.nro_proyecto
	group by t.id_sector,t.nro_proyecto; 
	
	if(cantidad_trabajando > 10) then
		raise exception 'No pueden haber mas de 10 ingenieros trabajando en el mismo proyecto';
	end if;
	return new;
end; $$ language 'plpgsql';


create or replace trigger tg_maximo_10_ingenieros
after insert or update 
on trabaja
for each row execute function fn_maximo_10_ingenieros();


delete from trabaja;

insert into ingeniero 
	values (11,'Maximiliano','Lujan','222222','Sistemas',100000);

select * from proyecto p;

--No nos deja realizar el insert, ya que estamos insertando
--11 ingenieros en el mismo proyecto
INSERT INTO trabaja (horas_semanales, id_ingeniero, id_sector, nro_proyecto)
VALUES
    (30, 1, 1, 101),  
    (25, 2, 1, 101),  
    (20, 3, 1, 101),  
    (35, 4, 1, 101),  
    (28, 5, 1, 101),  
    (22, 6, 1, 101),  
    (40, 7, 1, 101), 
    (32, 8, 1, 101),  
    (18, 9, 1, 101),  
    (38, 10, 1, 101),
    (38, 11, 1, 101);
