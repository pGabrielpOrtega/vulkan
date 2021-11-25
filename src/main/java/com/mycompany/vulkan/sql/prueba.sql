/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  gabri
 * Created: 26 oct. 2021
 */
Alter table clientes add nombre_documento varchar(50);

Alter table clientes add numIdentidad_cliente varchar(25);

Alter table empleado add numIdentidad_empleado varchar(30);

Alter table empleado add nombre_documento varchar(50);

Alter table empleado add empleadoNombre_puesto varchar(50);

Alter table proveedores add idnum_identificacion_empleado varchar(50);

Alter table proveedores add nombre_tipoDoc_empleado varchar(50);