/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  gabri
 * Created: 26 oct. 2021
 */
CREATE TABLE vulkan.b
(
    order_id        INT
        PRIMARY KEY,
    delivery_date   DATE NOT NULL,
    delivery_status TINYINT NOT NULL
);
SELECT id_puesto,nombre,descripcion FROM vulkan.puesto;