SELECT d.name AS Department ,e.name AS Employee , e.salary AS Salary
FROM Employee e
         JOIN Department d ON e.departmentId = d.id
         JOIN (SELECT MAX(salary) AS MaxSalary,departmentId
               FROM Employee
               GROUP BY departmentId) q ON e.salary = q.MaxSalary AND e.departmentId = q.departmentId;