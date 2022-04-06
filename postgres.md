https://tecadmin.net/how-to-install-postgresql-in-ubuntu-20-04/

sudo -u postgres psql

ALTER USER postgres PASSWORD 'newpassword';

##Function call from R2DBC for Integer
select * from employee;

CREATE OR REPLACE FUNCTION GetEmployeeById(emp_age INT)  
RETURNS Employee
LANGUAGE SQL   
AS   
$$  
SELECT * FROM Employee WHERE age = emp_age;  
$$;

SELECT * FROM GetEmployeeById(26) ;


\password
OR

psql -c "ALTER USER postgres WITH PASSWORD 'password';" 

sudo -u postgres psql -c "ALTER USER postgres PASSWORD 'password';"

##Function call from R2DBC for String

CREATE OR REPLACE FUNCTION GetEmployeeByDepartment(emp_dept TEXT)  
RETURNS Employee
LANGUAGE SQL   
AS   
$$  
SELECT * FROM Employee WHERE department = emp_dept;  
$$;

SELECT * FROM GetEmployeeByDepartment('abc') ;













