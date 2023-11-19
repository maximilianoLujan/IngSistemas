drop table alquiler cascade;
drop table tipo_alojamiento cascade;
drop table alquiler_aloj cascade;
drop table cliente cascade;
drop table alojamiento cascade;


create table cliente(
	id_cliente int not null,
	apellido varchar(60) not null,
	nombre varchar(40) not null,
	fecha_alta date not null,
	telefono varchar(20) not null,
	primary key(id_cliente)
);

INSERT INTO cliente (id_cliente, apellido, nombre, fecha_alta, telefono) VALUES
(1, 'González', 'Ana', '2023-01-02', '555-1234'),
(2, 'Rodríguez', 'Juan', '2023-02-15', '555-5678'),
(3, 'Fernández', 'María', '2023-03-20', '555-9101'),
(4, 'López', 'Carlos', '2023-04-05', '555-1122'),
(5, 'Martínez', 'Laura', '2023-05-12', '555-3344'),
(6, 'Pérez', 'Diego', '2023-06-18', '555-5566'),
(7, 'Giménez', 'Valeria', '2023-07-25', '555-7788'),
(8, 'Sánchez', 'Javier', '2023-08-30', '555-9900'),
(9, 'Alvarez', 'Natalia', '2023-09-14', '555-1122'),
(10, 'Romero', 'Matías', '2023-10-22', '555-3344'),
(11, 'Díaz', 'Camila', '2023-11-05', '555-5566'),
(12, 'Torres', 'Facundo', '2023-12-10', '555-7788'),
(13, 'Ríos', 'Sofía', '2024-01-17', '555-9900'),
(14, 'Mendoza', 'Gabriel', '2024-02-25', '555-1122'),
(15, 'Castro', 'Lucía', '2024-03-08', '555-3344'),
(16, 'Moreno', 'Emilio', '2024-04-14', '555-5566'),
(17, 'Flores', 'Agustina', '2024-05-21', '555-7788'),
(18, 'Benítez', 'Federico', '2024-06-27', '555-9900'),
(19, 'Acosta', 'Victoria', '2024-07-03', '555-1122'),
(20, 'Silva', 'Tomás', '2024-08-09', '555-3344');

create table tipo_alojamiento(
	id_alojamiento int not null,
	descripcion varchar(80) not null,
	superf_max decimal(10,2) not null,
	costo_diario_max decimal(10,2) null,
	primary key(id_alojamiento)
);

INSERT INTO tipo_alojamiento (id_alojamiento, descripcion, superf_max, costo_diario_max) VALUES
(1, 'Hotel', 100.00, 150.00),
(2, 'Cabaña', 80.50, 120.00),
(3, 'Apartamento', 70.25, 100.00),
(4, 'Hostal', 60.75, 80.00),
(5, 'Villa', 120.00, 200.00),
(6, 'Bungalow', 90.20, 130.00),
(7, 'Motel', 50.75, 70.00),
(8, 'Resort', 150.00, 250.00),
(9, 'Albergue', 40.00, 50.00),
(10, 'Posada', 55.50, 75.00),
(11, 'Refugio', 65.75, 90.00),
(12, 'Pensión', 75.00, 110.00),
(13, 'Hospedaje', 48.50, 65.00),
(14, 'Chalet', 85.00, 140.00),
(15, 'Hostería', 95.25, 160.00),
(16, 'Lodge', 110.00, 180.00),
(17, 'Mansion', 130.00, 220.00),
(18, 'Campamento', 30.00, 40.00),
(19, 'Alojamiento Rural', 78.50, 110.00),
(20, 'Posada Boutique', 68.75, 95.00);

create table alojamiento(
	nro_aloj int not null,
	id_alojamiento int not null,
	ubicacion varchar(40) not null,
	costo_diario decimal(10,2) not null,
	primary key(nro_aloj,id_alojamiento),
	foreign key (id_alojamiento) references tipo_alojamiento(id_alojamiento)
);


INSERT INTO alojamiento (nro_aloj, id_alojamiento, ubicacion, costo_diario) VALUES
(1, 1, 'Centro', 120.00),
(2, 1, 'Playa', 130.00),
(3, 1, 'Montaña', 110.00),
(4, 1, 'Centro Histórico', 125.00),
(5, 1, 'Zona Exclusiva', 140.00);

-- Cabaña (5 alojamientos)
INSERT INTO alojamiento (nro_aloj, id_alojamiento, ubicacion, costo_diario) VALUES
(6, 2, 'Bosque', 95.00),
(7, 2, 'Montañas', 100.00),
(8, 2, 'Rural', 85.00),
(9, 2, 'Campo', 110.00),
(10, 2, 'Bosque Encantado', 120.00);

-- Apartamento (5 alojamientos)
INSERT INTO alojamiento (nro_aloj, id_alojamiento, ubicacion, costo_diario) VALUES
(11, 3, 'Ciudad', 105.00),
(12, 3, 'Centro', 115.00),
(13, 3, 'Cerca del Mar', 95.00),
(14, 3, 'Pueblo', 100.00),
(15, 3, 'Centro Histórico', 110.00);

INSERT INTO alojamiento (nro_aloj, id_alojamiento, ubicacion, costo_diario) VALUES
(16, 4, 'Centro', 75.00),
(17, 4, 'Playa', 80.00),
(18, 4, 'Ciudad', 70.00),
(19, 4, 'Pueblo', 85.00),
(20, 4, 'Centro Histórico', 78.00);

drop table alquiler;
create table alquiler(
	id_alquiler int not null,
	id_cliente int not null,
	fecha_desde date not null,
	fecha_hasta date not null,
	importe_total decimal(10,2) not null,
	primary key(id_alquiler),
	foreign key(id_cliente) references cliente(id_cliente)
);

-- Alquileres adicionales para los clientes 1, 2, 3 y 4

-- Cliente 1
INSERT INTO alquiler (id_alquiler, id_cliente, fecha_desde, fecha_hasta, importe_total) VALUES
(21, 1, '2024-09-20', '2024-09-25', 480.00),
(22, 1, '2024-10-25', '2024-10-30', 600.00);

-- Cliente 2
INSERT INTO alquiler (id_alquiler, id_cliente, fecha_desde, fecha_hasta, importe_total) VALUES
(23, 2, '2024-11-30', '2024-12-05', 550.00),
(24, 2, '2025-01-05', '2025-01-10', 700.00);

-- Cliente 3
INSERT INTO alquiler (id_alquiler, id_cliente, fecha_desde, fecha_hasta, importe_total) VALUES
(25, 3, '2025-02-10', '2025-02-15', 800.00),
(26, 3, '2025-03-15', '2025-03-20', 900.00);

-- Cliente 4
INSERT INTO alquiler (id_alquiler, id_cliente, fecha_desde, fecha_hasta, importe_total) VALUES
(27, 4, '2025-04-20', '2025-04-25', 600.00),
(28, 4, '2025-05-25', '2025-05-30', 750.00);



create table alquiler_aloj(
	id_alquiler int not null,
	nro_aloj int not null,
	id_alojamiento int not null,
	observacion varchar(80) null,
	importe_alojamiento decimal(10,2) not null,
	primary key(id_alquiler,nro_aloj,id_alojamiento),
	foreign key (id_alquiler) references alquiler(id_alquiler),
	foreign key(nro_aloj,id_alojamiento) references alojamiento(nro_aloj,id_alojamiento)
);
select * from alquiler a;
select * from alojamiento a;

INSERT INTO alquiler_aloj (id_alquiler, nro_aloj, id_alojamiento, observacion, importe_alojamiento) VALUES
(21, 1, 1, 'Vista panorámica', 120.00),
(22, 2, 1, 'Con chimenea', 90.00),
(23, 3, 1, 'Cerca de la playa', 110.00),
(24, 4, 1, 'Rodeado de naturaleza', 70.00),
(25, 5, 1, 'Frente al lago', 180.00);

select * from alquiler;