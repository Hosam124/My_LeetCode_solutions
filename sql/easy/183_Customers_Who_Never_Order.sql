SELECT name AS Customers
FROM Customers
where id NOT IN (SELECT c.id
                 FROM Customers c
                 JOIN Orders o
                 ON c.id = o.customerId);