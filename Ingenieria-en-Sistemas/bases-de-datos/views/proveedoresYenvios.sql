INSERT INTO ARTICULO (id_articulo, descripcion, precio, peso, ciudad)
VALUES
    ('A001', 'Camiseta', 19.99, 0.3, 'Ciudad A'),
    ('A002', 'Pantalones', 29.99, 0.5, 'Ciudad B'),
    ('A003', 'Zapatos', 49.99, 0.8, 'Ciudad A'),
    ('A020', 'Bufanda', 9.99, 0.1, 'Ciudad C'),
    ('A030', 'Remera', 9.99, 0.1, 'Ciudad C');
    
   
INSERT INTO PROVEEDOR (id_proveedor, nombre, rubro, ciudad)
VALUES
    ('P007', 'Proveedor 7', 'Consolas', 'Tandil'),
    ('P016', 'Proveedor 16', 'moda', 'Tandil'),
	('P008', 'Proveedor 8', 'Futbol', 'Tandil'),
	('P009', 'Proveedor 9', 'Consolas', 'Tandil'),
	('P012', 'Proveedor 12', 'Musica', 'Tandil'),
    ('P002', 'Proveedor 2', 'Ropa', 'Ciudad B'),
    ('P003', 'Proveedor 3', 'Calzado', 'Ciudad A'),
    ('P010', 'Proveedor 10', 'Accesorios', 'Ciudad C');
    
   
INSERT INTO ENVIO (id_proveedor, id_articulo, cantidad)
VALUES
    ('P001', 'A030', 1000),
    ('P002', 'A002', 50),
    ('P003', 'A003', 75),
    ('P001', 'A003', 580),
    ('P002', 'A003', 900),
	('P002', 'A001', 1500),
    ('P010', 'A020', 200);
   
update ENVIOS500_m 
set cantidad = 990 
where id_proveedor = 'P010' and id_articulo = 'A020';
    
select * from envio; 

   
--a.1) ENVIOS500 con los envíos de 500 o más unidades (a partir de ENVIO) 
   
create or replace view ENVIOS500 as   
select * from envio
where cantidad >= 500;

select * from ENVIOS500;



--a.2) ENVIOS500-M con los envíos de entre 500 y 999 unidades (a partir de ENVIOS500) 
create or replace view ENVIOS500_M as
select * from ENVIOS500
where cantidad < 1000;

select * from ENVIOS500_m; 



--RUBROS_PROV con los diferentes rubros que poseen los proveedores ubicados en Tandil

create or replace view RUBROS_PROV as
select distinct rubro 
from proveedor 
where ciudad = 'Tandil';

select * from RUBROS_PROV;


--a.4) ENVIOS_PROV con los diferentes id y nombre de proveedor y la cantidad total de unidades enviadas 

create or replace view ENVIOS_PROV as
select p.id_proveedor,p.nombre,coalesce(sum(cantidad),0) as unidades_enviadas 
from proveedor p
left join envio v on p.id_proveedor = v.id_proveedor
group by p.id_proveedor,p.nombre;

select * from ENVIOS_PROV;






