USE ejerciciopractico;

-- --------------- PRCEDURE INSERTAR PRODUCTO -------------------------------------
DROP PROCEDURE IF EXISTS insertarProducto;
DELIMITER $$
CREATE PROCEDURE insertarProducto(
									/*Datos Producto*/
                                    IN varNombreProducto 		VARCHAR(100), 	-- 1
									IN varDescripcion 			TEXT,			-- 2
									IN varCantidadInventario 	INT,			-- 3
									IN varEstatus 				INT,			-- 4
                                    
                                    /*Datos Movimiento*/
									IN varIdUsuario 			INT,			-- 5
                                    
                                    /*Valor de retorno*/
                                    OUT varIdProducto			INT				-- 6
									
)
BEGIN
	-- Comensamos insertando en la tabla Productos
    INSERT INTO productos (nombreProducto, descripcion, cantidadInventario, estatus, fechaAlta) 
    VALUES (varNombreProducto, varDescripcion, varCantidadInventario, varEstatus, NOW());
    
    -- Obtenemos el id del producto que se genero
    SET varIdProducto = LAST_INSERT_ID();
    
    -- Insertamos en la tabla movimiento
    INSERT INTO movimientos_inventario (idProducto, idUsuario, tipoMovimiento, cantidad, fechaMovimiento)
    VALUES (varIdProducto, varIdUsuario, 'Entrada', 0, NOW());
END
$$
DELIMITER ;

-- --------------- PRCEDURE CAMBIAR CANTIDAD -------------------------------------
DROP PROCEDURE IF EXISTS cambiarCantidad;
DELIMITER $$
CREATE PROCEDURE cambiarCantidad(
									IN varCantidad 		INT,
									IN varIdProducto 	INT,
									IN varIdUsuario 	INT
)
BEGIN 
	UPDATE productos set cantidadInventario = varCantidad WHERE idProducto= varIdProducto;
    
    INSERT INTO movimientos_inventario (idProducto, idUsuario, tipoMovimiento, cantidad, fechaMovimiento)
    VALUES (varIdProducto, varIdUsuario, 'Salida', varCantidad, NOW());
END
$$
DELIMITER ;
    