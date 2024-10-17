USE ejerciciopractico;

DROP VIEW IF EXISTS vHistorialMovimiento;
CREATE VIEW vHistorialMovimiento AS 
	SELECT 
	MI.idMovimiento, 	
	MI.tipoMovimiento, 		
	MI.cantidad, 			
	MI.fechaMovimiento,
 	P.idProducto,
    P.nombreProducto,
    U.idUsuario,
    U.nombre
	FROM movimientos_inventario MI 
		INNER JOIN productos P ON MI.idProducto = P.idProducto
        INNER JOIN usuarios U ON MI.idUsuario = U.idUsuario
	ORDER BY tipoMovimiento;

