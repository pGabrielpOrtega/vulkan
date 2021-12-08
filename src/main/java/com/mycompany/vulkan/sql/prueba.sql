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

ALTER TABLE reservacion MODIFY id_reservacion INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE producto_almacen ADD desactivado INT NOT NULL DEFAULT 0;

Alter table tipo_documento add nombre varchar(50);

Alter table Tipo_pago add nombre varchar(50);

Alter table proveedores add apellido varchar(50);

Alter table proveedores add email varchar(50);

/*Todo lo que añadi a las tablas el más confuso seria numIdentidad es su indentidad 
que se esta registrando osea los numeros pero lo dejo en varchar por el momento ya que visa ocupa letras*/

