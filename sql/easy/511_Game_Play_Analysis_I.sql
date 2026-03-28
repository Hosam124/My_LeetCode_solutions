SELECT r.player_id , r.first_login
FROM (SELECT    player_id ,
                event_date AS first_login ,
                DENSE_RANK() OVER (PARTITION BY player_id ORDER BY event_date) AS rnk
                FROM Activity) r
WHERE r.rnk = 1;