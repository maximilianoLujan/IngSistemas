/*
 * Ejercicio 5
 * Para el esquema Voluntarios, implemente un trigger que:
 * Ante un cambio de tarea de un voluntario, coloque en 0 la cantidad de horas aportadas, independientemente de si el valor de horas_aportadas de 
 * la sentencia update es diferente.
 * cuando se actualice la cantidad de horas aportadas, el nuevo valor no puede ser ni menor, ni superior al 10 % del valor que tenía anteriormente.
 * */

--Creando las tablas de voluntarios y tareas
create table voluntario(
 nro_voluntario serial not null,
 nombre varchar(50) not null,
 apellido varchar(50) not null,
 id_tarea varchar(20) not null,
 horas_aportadas int not null,
 primary key(nro_voluntario)
);
create table tarea(
 id_tarea varchar(20) not null,
 min_horas int not null,
 primary key(id_tarea)
);


--Agregando constraint de foreign key
alter table voluntario 
add constraint fk_voluntario_tarea
foreign key(id_tarea) references tarea(id_tarea);


--Agregando valores a las tablas
insert into tarea values 
('AD_PRES',20000),
('AD_VP',15000),
('AD_ASST',3000);
insert into voluntario values
(1,'Maximiliano','Lujan','AD_PRES',4000),
(2,'Mateo','Suarez','AD_PRES',3000),
(3,'Guillermo','Redondo','AD_VP',200);



--Creando trigger para que cuando se actualice un voluntario, las horas aportadas sean 0
create or replace trigger trigger_cambio_tarea
after update of id_tarea on voluntario 
for each row execute function funcion_cambio_tarea();



create or replace function funcion_cambio_tarea()
returns trigger as $$
begin 
	update voluntario 
	set horas_aportadas = 0
	where nro_voluntario = new.nro_voluntario;	
	return new;
end;
$$ language 'plpgsql';



--Probando el trigger que creamos
update voluntario 
set id_tarea = 'AD_ASST';


select * from voluntario v;