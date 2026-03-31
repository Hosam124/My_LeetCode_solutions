SELECT emp.name
FROM Employee emp
         JOIN (  SELECT e.id,COUNT(*) AS reports
                 FROM Employee e
                          JOIN Employee m
                               ON e.id = m.managerId
                 GROUP BY e.id ) mang
WHERE mang.id = emp.id AND mang.reports >= 5 ;