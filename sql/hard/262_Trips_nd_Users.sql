SELECT  nb.request_at AS "Day",
        COALESCE(ROUND(c.Total_Cancelled /nb.Total_Not_Banned , 2),0) AS "Cancellation Rate"
FROM (
         SELECT COUNT(*) AS Total_Not_Banned , r1.request_at
         FROM (SELECT  t.id,c.banned AS banned_client, t.request_at
               FROM Trips t
                        JOIN Users c ON t.client_id = c.users_id ) r1
                  JOIN (SELECT  t.id,d.banned AS banned_driver, t.request_at
                        FROM Trips t
                                 JOIN Users d ON t.driver_id = d.users_id) r2

                       ON r1.id = r2.id AND r1.banned_client = r2.banned_driver AND  r1.banned_client = "No"
         GROUP BY r1.request_at
     ) nb
         LEFT JOIN (
    SELECT COUNT(*) AS Total_Cancelled , r1.request_at
    FROM (SELECT  t.id,c.banned AS banned_client, t.request_at, t.status
          FROM Trips t
                   JOIN Users c ON t.client_id = c.users_id ) r1
             JOIN (SELECT  t.id,d.banned AS banned_driver, t.request_at, t.status
                   FROM Trips t
                            JOIN Users d ON t.driver_id = d.users_id) r2

                  ON r1.id = r2.id AND  r1.banned_client = "No" AND r1.status != "completed"
    GROUP BY r1.request_at
) c
                   ON nb.request_at = c.request_at
WHERE nb.request_at >= "2013-10-01" AND nb.request_at <= "2013-10-03";
