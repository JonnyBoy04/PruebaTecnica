-- ---------------------------------------------------------------- --
-- Archivo: 01_DDL_Ejercicio.sql									-- 
-- Version: 1.0                                                     --
-- Autor:   Simón Jonathan Zendejas Gutiérrez						--
-- Email:   simonzdjgtz@gmail.com									--
-- Fecha de elaboracion: 10-15-2024                                 --
-- ---------------------------------------------------------------- --
DROP DATABASE IF EXISTS ejerciciopractico;
CREATE DATABASE ejerciciopractico;

USE ejerciciopractico;

-- ------------- TABLA ROLES -------------- --
CREATE TABLE roles(
	idRol 				INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombreRol 			VARCHAR(50)
);

-- ------------- TABLA USUARIOS -------------- --
CREATE TABLE usuarios(
	idUsuario 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre 				VARCHAR(100),
    correo 				VARCHAR(50),
    contrasenia 		VARCHAR(25),
    idRol 				INT,
    estatus 			INT,
    CONSTRAINT fk_usuario_rol FOREIGN KEY (idRol) 
                REFERENCES roles(idRol) 
);

-- ------------- TABLA PERMISOS -------------- --
CREATE TABLE permisos(
	idPermiso 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombrePermiso 		VARCHAR(50)
);

-- ------------- TABLA ROLES_PERMISOS -------------- --
CREATE TABLE roles_permisos(
	idRol 				INT NOT NULL,
    idPermiso 			INT NOT NULL,
    CONSTRAINT fk_rolespermisos_rol FOREIGN KEY (idRol) 
                REFERENCES roles(idRol),
    CONSTRAINT fk_rolespermisos_permiso FOREIGN KEY (idPermiso) 
                REFERENCES permisos(idPermiso)
);

-- ------------- TABLA PRODUCTOS -------------- --
CREATE TABLE productos(
	idProducto 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nombreProducto 		VARCHAR(100),
	descripcion 		TEXT,
	cantidadInventario 	INT,
	estatus 			INT,
	fechaAlta 			DATETIME
);

-- ------------- TABLA MOVIMIENTOS_INVENTARIO -------------- --
CREATE TABLE movimientos_inventario(
	idMovimiento 		INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	idProducto 			INT NOT NULL,    
	idUsuario 			INT NOT NULL,
	tipoMovimiento 		VARCHAR(20),
	cantidad 			INT,
	fechaMovimiento 	DATETIME,
    CONSTRAINT fk_movinventario_productos FOREIGN KEY (idProducto) 
                REFERENCES productos(idProducto),
    CONSTRAINT fk_movinventario_usuario FOREIGN KEY (idUsuario) 
                REFERENCES usuarios(idUsuario)
);