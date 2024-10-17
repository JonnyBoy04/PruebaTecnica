USE ejerciciopractico;

INSERT INTO roles (nombreRol) VALUES 
('Administrador'),
('Almacenista');

INSERT INTO usuarios (nombre, correo, contrasenia, idRol, estatus) VALUES
('Ana Pérez', 'ana.perez@libreria.com', 'admin123', 1, 1),  -- Administrador
('Luis Gómez', 'luis.gomez@libreria.com', 'almacen456', 2, 1);  -- Almacenista

INSERT INTO permisos (nombrePermiso) VALUES
('Ver módulo inventario'),
('Agregar nuevos productos'),
('Aumentar inventario'),
('Dar de baja/reactivar un producto'),
('Ver módulo para Salida de productos'),
('Sacar inventario del almacén'),
('Ver módulo del histórico');

-- Permisos del Administrador
INSERT INTO roles_permisos (idRol, idPermiso) VALUES
(1, 1), -- Ver módulo inventario
(1, 2), -- Agregar nuevos productos
(1, 3), -- Aumentar inventario
(1, 4), -- Dar de baja/reactivar un producto
(1, 7); -- Ver módulo del histórico

-- Permisos del Almacenista
INSERT INTO roles_permisos (idRol, idPermiso) VALUES
(2, 1), -- Ver módulo inventario
(2, 5), -- Ver módulo para Salida de productos
(2, 6); -- Sacar inventario del almacén

INSERT INTO productos (nombreProducto, descripcion, cantidadInventario, estatus, fechaAlta) VALUES
('El Quijote', 'Libro clásico de Miguel de Cervantes', 10, 1, NOW()),
('Cien Años de Soledad', 'Obra maestra de Gabriel García Márquez', 5, 1, NOW()),
('La Odisea', 'Épico poema griego atribuido a Homero', 2, 0, '2024-01-01');  -- Producto dado de baja

INSERT INTO movimientos_inventario (idProducto, idUsuario, tipoMovimiento, cantidad, fechaMovimiento) VALUES
(1, 2, 'Salida', 3, NOW()),  -- Almacenista saca 3 unidades de "El Quijote"
(2, 1, 'Entrada', 0, NOW()); -- Administrador agrega 5 unidades de "Cien Años de Soledad"
