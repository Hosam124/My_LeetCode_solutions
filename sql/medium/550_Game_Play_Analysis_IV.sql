SELECT ROUND ((SELECT COUNT(*)
               FROM (SELECT  player_id,
                             event_date,
                             DENSE_RANK() OVER (PARTITION BY player_id ORDER BY event_date) AS rnk
                     FROM Activity) r1
                        JOIN  (SELECT  player_id,
                                       event_date,
                                       DENSE_RANK() OVER (PARTITION BY player_id ORDER BY event_date) AS rnk
                               FROM Activity) r2
                              ON r1.player_id = r2.player_id AND r1.rnk = 1 AND r2.rnk = 2 AND DATEDIFF(r2.event_date, r1.event_date) = 1) / COUNT(DISTINCT player_id),2) AS fraction
FROM ACtivity;
