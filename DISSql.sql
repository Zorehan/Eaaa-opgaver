
--Opgave 1

SELECT Product.prodID, Product.prodName, Product.unitPrice
FROM Product
JOIN Supplier ON Product.suppID = Supplier.suppID
WHERE Supplier.compName = 'FixFax';

--Opgave 2

SELECT Order_T.orderID, 
       SUM(OrderItem.quantity * Product.unitPrice) AS totalPrice
FROM Order_T
JOIN OrderItem ON Order_T.orderID = OrderItem.orderID
JOIN Product ON OrderItem.prodID = Product.prodID
GROUP BY Order_T.orderID;

--Opgave 3

SELECT Order_T.orderID,
       SUM(OrderItem.quantity * Product.unitPrice) AS totalPrice
FROM Order_T
JOIN OrderItem ON Order_T.orderID = OrderItem.orderID
JOIN Product ON OrderItem.prodID = Product.prodID
GROUP BY Order_T.orderID
HAVING SUM(OrderItem.quantity * Product.unitPrice) > 200;

--Opgave 4

SELECT Order_T.orderID,
       Product.prodName AS productName,
       Product.unitPrice AS entityPrice,
       OrderItem.quantity AS amount,
       OrderItem.quantity * Product.unitPrice AS itemTotalPrice,
       SUM(OrderItem.quantity * Product.unitPrice) OVER (PARTITION BY Order_T.orderID) AS totalOrderPrice
FROM Order_T
JOIN OrderItem ON Order_T.orderID = OrderItem.orderID
JOIN Product ON OrderItem.prodID = Product.prodID
WHERE Order_T.orderID = 1; --det er her man angiver ordrenummeret


--Opgave 5

CREATE PROCEDURE GetOrderDetails
    @OrderID INT
AS
BEGIN
    SELECT Order_T.orderID,
           Product.prodName AS productName,
           Product.unitPrice AS entityPrice,
           OrderItem.quantity AS amount,
           OrderItem.quantity * Product.unitPrice AS itemTotalPrice,
           SUM(OrderItem.quantity * Product.unitPrice) OVER (PARTITION BY Order_T.orderID) AS totalOrderPrice
    FROM Order_T
    JOIN OrderItem ON Order_T.orderID = OrderItem.orderID
    JOIN Product ON OrderItem.prodID = Product.prodID
    WHERE Order_T.orderID = @OrderID;
END;

EXEC GetOrderDetails @OrderID = 2; --skal eksekveres med den her linje


--Opgave 6 

CREATE TRIGGER SawOrder
ON OrderItem
AFTER INSERT
AS
BEGIN
    DECLARE @SawCount INT;
    DECLARE @OrderID INT;

    SELECT @OrderID = orderID 
    FROM inserted;

    SELECT @SawCount = SUM(OrderItem.quantity)
    FROM OrderItem
    JOIN Product ON OrderItem.prodID = Product.prodID
    WHERE OrderItem.orderID = @OrderID
      AND Product.prodName = 'Sav';

    IF @SawCount > 5
    BEGIN
        PRINT 'DER ER FOR MANgE SAAAVE ÅH NEEEEJ';
    END
END;

--Opgave 7

SELECT Supplier.suppID,
       Supplier.compName,
       COUNT(Product.prodID) AS productCount
FROM Supplier
LEFT JOIN Product ON Supplier.suppID = Product.suppID
GROUP BY Supplier.suppID, Supplier.compName;

--Opgave 8

CREATE VIEW SupplierProductView AS
SELECT Supplier.suppID,
       Supplier.compName,
       Product.prodID,
       Product.prodName,
       Product.unitPrice
FROM Supplier
LEFT JOIN Product ON Supplier.suppID = Product.suppID;

SELECT prodName, unitPrice
FROM SupplierProductView
WHERE compName = 'Primus';

--Opgave 9


