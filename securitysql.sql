--Opgave 9.1
use Securitytest
exec sp_addlogin 'peter','Gergeren123,'
exec sp_addlogin 'dan','Gergeren123,'
exec sp_addlogin 'susan','Gergeren123,'

exec sp_grantdbaccess 'peter'
exec sp_grantdbaccess 'dan','killerdan'
exec sp_grantdbaccess 'susan'


exec sp_addrole 'programmer'
exec sp_addrole 'normaluser'
exec sp_addrole 'superuser'
exec sp_addrolemember 'programmer', 'killerdan'

exec sp_addrolemember 'db_ddladmin','programmer'

--Opgave 9.3

exec sp_addrolemember 'normalusers', 'normaluser'

--Opgave 9.4

GRANT CREATE TABLE TO programmer;
GRANT CREATE VIEW TO programmer;
GRANT CREATE PROCEDURE TO programmer;
GRANT CREATE FUNCTION TO programmer;


GRANT ALTER ON SCHEMA::dbo TO programmer;
GRANT CONTROL ON SCHEMA::dbo TO programmer;


GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.Table1 TO programmer;



--Opgave 9.4

USE Securitytest;

DROP TABLE IF EXISTS dbo.TestTable1;
DROP TABLE IF EXISTS dbo.TestTable2;

EXECUTE AS USER = 'killerdan';

BEGIN TRY
    CREATE TABLE dbo.TestTable1 (
        loen INT
    );
    PRINT 'Table dbo.TestTable1 created successfully.';
END TRY
BEGIN CATCH
    PRINT 'Error creating dbo.TestTable1: ' + ERROR_MESSAGE();
END CATCH;

BEGIN TRY
    CREATE TABLE dbo.TestTable2 (
        cpr NVARCHAR(50)
    );
    PRINT 'Table dbo.TestTable2 created successfully.';
END TRY
BEGIN CATCH
    PRINT 'Error creating dbo.TestTable2: ' + ERROR_MESSAGE();
END CATCH;

REVERT;

--Opgave 9.5

GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.TestTable1 TO superuser;
GRANT SELECT, INSERT, UPDATE ON dbo.TestTable2 TO superuser;

--Opgave 9.6

USE Securitytest;
GO

CREATE VIEW dbo.View_Loen_Under500000 AS
SELECT loen
FROM dbo.TestTable1
WHERE loen < 500000;
GO

GRANT SELECT ON dbo.View_Loen_Under500000 TO normalusers;

GRANT SELECT ON dbo.TestTable2 TO normalusers;
