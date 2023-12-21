package com.example.Employee.Repository;

	import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee.Entity.Employee;


	

	public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
		
	}



