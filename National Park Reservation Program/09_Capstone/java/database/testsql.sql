SELECT * FROM site WHERE campground_id = 1 AND site_id NOT IN (SELECT site_id FROM reservation 
WHERE ( to_date <= '2020-01-19' AND from_date >= '2020-11-19' ) 
OR ( to_date <= '2020-01-19' AND from_date >= '2020-11-19' ) 
OR (to_date >= '2020-01-19' AND to_date <= '2020-01-19' )) LIMIT 5 ;

SELECT * FROM park ORDER BY name;

SELECT * FROM site  WHERE campground_id = ? AND site_id NOT IN (SELECT site_id FROM reservation 
WHERE ( to_date <= ? AND  from_date >= ?) 
OR ( to_date <= ? AND from_date >= ? ) 
OR (to_date >= ? AND to_date <= ?)) ;


these are the parameters


campgroundId, StartDate, StartDate,  EndDate, EndDate, StartDate, EndDate)

SELECT * FROM site  WHERE campground_id = < AND reservation.site_id NOT IN (SELECT site_id FROM reservation 
WHERE ( to_date < ? AND  from_date) > ? OR ( to_date < ? AND from_date > ? ) OR (to_date > ? to_date < ?);

campground_id = 1  AND 
(to_date > '2020-01-01' AND from_date  '2020-12-31');

SELECT * FROM employee as e WHERE e.employee_id NOT IN (SELECT project_employee.employee_id FROM project_employee );

?s are

campgroundId, StartDate, EndDate,;


