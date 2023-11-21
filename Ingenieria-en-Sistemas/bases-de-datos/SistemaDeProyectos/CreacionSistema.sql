create table sector(
	id_sector int not null,
	descripcion varchar(20) not null,
	ubicacion varchar(40) not null,
	cantidad_empleados int not null,
	primary key (id_sector)
);

INSERT INTO sector VALUES (1, 'Sector A', 'Ubicacion A', 50),
(2, 'Sector B', 'Ubicacion B', 30),
(3, 'Sector C', 'Ubicacion C', 25),
(4, 'Sector D', 'Ubicacion D', 40),
(5, 'Sector E', 'Ubicacion E', 60),
(6, 'Sector F', 'Ubicacion F', 45),
(7, 'Sector G', 'Ubicacion G', 20),
(8, 'Sector H', 'Ubicacion H', 55),
(9, 'Sector I', 'Ubicacion I', 35),
(10, 'Sector J', 'Ubicacion J', 48);

select * from sector s;


create table ingeniero(
	id_ingeniero int not null,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	contacto varchar(20) null,
	especialidad varchar(40) not null,
	remuneracion decimal(8,2) not null,
	primary key(id_ingeniero)
);


INSERT INTO ingeniero (id_ingeniero, nombre, apellido, contacto, especialidad, remuneracion)
VALUES
    (1, 'Juan', 'Lopez', '555-1234', 'Ingeniería Eléctrica', 75000.00),
    (2, 'Maria', 'Gomez', '555-5678', 'Ingeniería Mecánica', 82000.00),
    (3, 'Carlos', 'Rodriguez', '555-9012', 'Ingeniería Civil', 70000.00),
    (4, 'Laura', 'Martinez', '555-3456', 'Ingeniería de Software', 90000.00),
    (5, 'Pedro', 'Garcia', '555-7890', 'Ingeniería Química', 78000.00),
    (6, 'Ana', 'Perez', '555-2345', 'Ingeniería Industrial', 85000.00),
    (7, 'Gabriel', 'Sanchez', '555-6789', 'Ingeniería Informática', 92000.00),
    (8, 'Sofia', 'Fernandez', '555-0123', 'Ingeniería Biomédica', 77000.00),
    (9, 'Diego', 'Hernandez', '555-4567', 'Ingeniería Aeroespacial', 88000.00),
    (10, 'Valentina', 'Luna', '555-8901', 'Ingeniería Ambiental', 79000.00);

   
select * from ingeniero i;

create table proyecto(
	id_sector int not null,
	nro_proyecto int not null,
	nombre varchar(50) not null,
	presupuesto decimal(12,2) not null,
	fecha_inicio date not null,
	fecha_fin date null,
	director int not null,
	primary key(id_sector,nro_proyecto),
	foreign key (id_sector) references sector(id_sector),
	foreign key (director) references ingeniero(id_ingeniero)
);

INSERT INTO proyecto (id_sector, nro_proyecto, nombre, presupuesto, fecha_inicio, fecha_fin, director)
VALUES
    (1, 101, 'Proyecto 1', 150000.00, '2023-01-15', '2023-06-30', 1),
    (1, 102, 'Proyecto 2', 200000.00, '2023-02-01', '2023-07-31', 2),
    (1, 103, 'Proyecto 3', 120000.00, '2023-03-10', '2023-08-15', 3),
    (2, 104, 'Proyecto 4', 180000.00, '2023-04-05', '2023-09-30', 4),
    (2, 105, 'Proyecto 5', 250000.00, '2023-05-20', '2023-10-31', 5),
    (2, 106, 'Proyecto 6', 160000.00, '2023-06-15', '2023-11-15', 6),
    (2, 107, 'Proyecto 7', 300000.00, '2023-07-01', '2023-12-31', 7),
    (3, 108, 'Proyecto 8', 170000.00, '2023-08-10', '2024-01-31', 8),
    (3, 109, 'Proyecto 9', 220000.00, '2023-09-05', '2024-02-28', 9),
    (5, 110, 'Proyecto 10', 190000.00, '2023-10-20', '2024-03-31', 10);
   
select * from proyecto p;

create table trabaja(
	horas_semanales int null,
	id_ingeniero int not null,
	id_sector int not null,
	nro_proyecto int not null,
	primary key(id_ingeniero,id_sector,nro_proyecto),
	foreign key (id_ingeniero) references ingeniero(id_ingeniero),
	foreign key (id_sector,nro_proyecto) references proyecto(id_sector,nro_proyecto)
);


INSERT INTO trabaja (horas_semanales, id_ingeniero, id_sector, nro_proyecto)
VALUES
    (30, 1, 1, 101),  
    (25, 2, 2, 104),  
    (20, 3, 1, 101),  
    (35, 4, 1, 101),  
    (28, 2, 1, 101),  
    (22, 3, 2, 104),  
    (40, 1, 2, 104), 
    (32, 2, 1, 103),  
    (18, 3, 1, 103),  
    (38, 1, 1, 103);

select * from trabaja t;