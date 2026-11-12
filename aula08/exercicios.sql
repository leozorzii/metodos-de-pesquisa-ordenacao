USE BIBLIOTECA;

-- 1 - crie um trigger que impeça a insercao de livros com o mesmo titulo na tabela livro
GO
CREATE OR ALTER TRIGGER trg_livros_mesmo_titulo
ON Livro
INSTEAD OF INSERT
AS
BEGIN
    IF EXISTS(
        -- titulo que ja existe na tabela livro
        SELECT 1
        FROM inserted AS I
        JOIN Livro AS L
        ON I.titulo = L.titulo
    )
    BEGIN
        RAISERROR('Erro: nao eh permitido inserir livros com o mesmo titulo', 16, 1);
        RETURN;
    END
    ELSE
    BEGIN
        INSERT INTO livro (isbn, titulo, ano, fk_editora, fk_categoria)
        VALUES ('1111111111', 'O Papai é Pop', 2016, 4, 3);
       PRINT 'teste'
    END
END
GO--trigger desativado

-- 2 - criar um trigger que atualize automaticamente 
-- o ano de publicaao na tabela Livro
-- para o ano atual quando um novo livro eh inserido
GO
CREATE OR ALTER TRIGGER trg_atualiza_ano_atual
ON Livro
AFTER INSERT
AS
BEGIN
    UPDATE L
    SET L.ano = YEAR(GETDATE())
    FROM Livro AS L
    INNER JOIN inserted i ON L.isbn = i.isbn;
END

INSERT INTO Livro(isbn, titulo, ano, fk_editora, fk_categoria)
VALUES('124124123', 'Bob esponja body pants', 2001, 5, 2)



EXEC sp_helptext 'trg_livros_mesmo_titulo';
DISABLE TRIGGER trg_livros_mesmo_titulo ON Livro;

-- 3 - crie um trigger que exclua automaticamente registros
-- da tabela livroAutor quando o livro correspondente eh
-- excluido da tabela livro

GO
CREATE OR ALTER TRIGGER trg_exclui_registros_livroAutor
ON Livro
INSTEAD OF DELETE
AS
BEGIN
    -- deleta o filho primeiro
     DELETE la
     FROM LivroAutor la
     INNER JOIN deleted d ON la.fk_livro = d.isbn
    
    -- agora deleta o pai
    DELETE L
    FROM Livro L
    INNER JOIN deleted d ON L.isbn = d.isbn
END;
GO

    DELETE FROM Livro 
    WHERE isbn = '9788577345670'

    
SELECT *
FROM Livro AS L
SELECT *
FROM LivroAutor

-- 4 - Crie um trigger que atualize o numero total de livros em uma categoria especifica na tabela Categoria
-- sempre que um novo livro é inserido
GO
CREATE OR ALTER TRIGGER trg_atualiza_total_livros
ON Livro
AFTER INSERT
AS
BEGIN
    DECLARE @id_cat INT, @total INT;
    SELECT @id_cat = fk_categoria FROM inserted;

    SELECT @total = COUNT(*)
    FROM Livro
    WHERE Livro.fk_categoria = @id_cat
    PRINT 'O total de livros para a categoria ' + CAST(@id_cat AS VARCHAR) + ' SERIA: ' + CAST(@total AS VARCHAR);
END;
GO
-- TESTANDO COM UM INSERT
insert into livro values('97211222458','senta aqui','2005',4,3);
SELECT *
FROM Livro

SELECT *
FROM Categoria AS C
INNER JOIN Livro AS L
ON C.id = L.fk_categoria
WHERE C.id = 3

-- 5 - cria um trigger que restrinja a exclusao de categorias na tabela
-- Categoria se houver livros associados a essa categoria
GO
CREATE OR ALTER TRIGGER trg_restringe_exclusao
ON Categoria
INSTEAD OF DELETE
AS
BEGIN
    IF EXISTS(
        SELECT 1 
        FROM Livro AS L 
        JOIN deleted d ON L.fk_categoria = d.id
        )
        BEGIN
            RAISERROR('Nao é possivel excluir categoria pois ela esta ligada a um livro', 16, 1)
        END
    ELSE
        BEGIN
            DELETE FROM Categoria
            WHERE id IN (SELECT id FROM deleted)
        END
END;
GO

CREATE TABLE Auditoria(
  id INT IDENTITY(1,1) PRIMARY KEY,
    isbn VARCHAR(20),
    titulo_antigo VARCHAR(200),
    titulo_novo VARCHAR(200),
    data_alteracao DATETIME DEFAULT GETDATE()
);
GO
-- 6 - crie um trigger que registre em uma tabela de auditoria sempre que um livro for atualizado na tabela livro
GO
CREATE OR ALTER TRIGGER trg_atualiza_auditoria
ON Livro
AFTER UPDATE
AS
BEGIN
    INSERT INTO Auditoria(isbn, titulo_antigo, titulo_novo)
    SELECT d.isbn, d.titulo, i.titulo
    FROM inserted as i
    JOIN deleted as d ON d.isbn = i.isbn
END
GO 


UPDATE Livro
SET titulo = 'Tome mardito'
WHERE isbn = '124124123'


-- 7 - crie um trigger que atualize automaticamente o campo nacionalidade na tabela
-- Autor para 'Desconhecida' sempre que um autor for excluido da tabela Autor

GO
CREATE OR ALTER TRIGGER trg_autor_nacionalidade_desconhecida
ON Autor
INSTEAD OF DELETE
AS
BEGIN
    UPDATE A
    SET A.nacionalidade = 'Desconhecida'
    FROM Autor AS A
    INNER JOIN deleted AS d ON A.id = d.id;
END;
GO

DELETE FROM Autor
WHERE id = 1;

SELECT *
FROM Autor;




--views


USE MICROSOFT;


-- 1- Crie uma visão que liste todos os funcionários que não são chefes.
GO
CREATE OR ALTER VIEW vw_lista_nao_chefes
AS
SELECT *
FROM Employees AS E
WHERE NOT EXISTS(
    SELECT *
    FROM Employees AS S -- subordinados
    WHERE S.ReportsTo = E.EmployeeID
);
GO

SELECT *
FROM vw_lista_nao_chefes;


-- 2- Faça uma visão que liste a quantidade de vendas que cada produto
-- (o quanto cada produto foi vendido).
GO
CREATE OR ALTER VIEW vw_lista_vendas_por_produto
AS
SELECT  P.ProductID, 
        P.ProductName, 
        SUM(OD.Quantity) AS TotalVendido
FROM Products AS P
JOIN [Order Details] AS OD
    ON OD.ProductID = P.ProductID
    GROUP BY P.ProductID, P.ProductName;
GO

SELECT * 
FROM vw_lista_vendas_por_produto ORDER BY TotalVendido DESC;


-- 3- Faça uma visão que liste os territórios e quantos vendedores estão vinculados a ele.
GO
CREATE OR ALTER VIEW vw_lista_territorios_vendedores
AS
SELECT T.TerritoryDescription, COUNT(ET.EmployeeID) AS qtdVendedores
FROM Territories AS T
LEFT JOIN EmployeeTerritories AS ET
ON T.TerritoryID = ET.TerritoryID
GROUP BY T.TerritoryID, T.TerritoryDescription
GO

SELECT *
FROM vw_lista_territorios_vendedores;


-- 4- Faça uma visão que retorne o nome do cliente da venda de maior valor.
GO
CREATE OR ALTER VIEW vw_cliente_maior_venda
AS
SELECT TOP 1 C.CompanyName, 
            SUM(OD.UnitPrice * OD.Quantity * (1 - OD.Discount)) AS ValorVenda
FROM Customers AS C
JOIN Orders AS O ON C.CustomerID = O.CustomerID
JOIN [Order Details] AS OD ON O.OrderID = OD.OrderID
GROUP BY O.OrderID, C.CompanyName
ORDER BY ValorVenda DESC;
GO

SELECT *
FROM vw_cliente_maior_venda


-- 5- Faça uma visão que liste os vendedores ordenados pela lucratividade.
GO
CREATE OR ALTER VIEW vw_vendedores_ordenados_lucratividade
AS  
    SELECT E.FirstName, CAST(SUM(OD.UnitPrice * OD.Quantity * (1 - OD.Discount)) AS DECIMAL(10,2)) AS ValorVenda
    FROM Employees AS E
    JOIN Orders AS O ON E.EmployeeID = O.EmployeeID
    JOIN [Order Details] AS OD ON O.OrderID = OD.OrderID
    GROUP BY E.FirstName
GO

SELECT *
FROM vw_vendedores_ordenados_lucratividade
ORDER BY ValorVenda DESC;


-- 6- Faça uma visão que retorne os produtos, seu fornecedor, sua categoria, seu preço e a informação de ele estar descontinuado ou não, para aqueles que possuem estoque
GO
CREATE OR ALTER VIEW vw_produtos_em_estoque
AS
SELECT  P.ProductID,
        P.ProductName,
        S.CompanyName AS Fornecedor,
        C.CategoryName AS Categoria,
        P.UnitPrice AS Preco,
        CASE WHEN P.Discontinued = 1 THEN 'Descontinuado' ELSE 'Ativo' END AS Situacao
FROM Products AS P
JOIN Suppliers AS S ON S.SupplierID = P.SupplierID
JOIN Categories AS C ON C.CategoryID = P.CategoryID
WHERE P.UnitsInStock > 0;
GO

SELECT *
FROM vw_produtos_em_estoque;





