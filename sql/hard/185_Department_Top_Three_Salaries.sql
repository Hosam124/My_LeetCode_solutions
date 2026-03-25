SELECT  d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary
FROM Employee e
         JOIN Department d ON e.departmentId = d.id
         JOIN (
    SELECT DISTINCT r.departmentId,
                    r.salary
    FROM (
             SELECT  salary,
                     departmentId,
                     DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rnk
             FROM Employee

         ) r
    WHERE rnk<=3
) q ON e.departmentId = q.departmentId  AND e.salary = q.salary;
