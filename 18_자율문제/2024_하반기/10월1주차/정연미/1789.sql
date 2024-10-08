SELECT employee_id, department_id
FROM Employee
where primary_flag = 'Y' or
employee_id in (select employee_id from employee group by employee_id having count(employee_id)=1);
