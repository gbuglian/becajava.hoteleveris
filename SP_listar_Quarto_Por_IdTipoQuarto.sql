CREATE PROCEDURE SP_LISTAR_QUARTO_POR_IdTipoQuarto
	@id BIGINT
AS
BEGIN 
	SELECT
		*
	FROM Quarto WHERE IdTipoQuarto = @id
END

EXEC SP_LISTAR_QUARTO_POR_IdTipoQuarto 2