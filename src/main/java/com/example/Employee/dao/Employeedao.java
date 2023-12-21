package com.example.Employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;

@Repository

public class Employeedao {
	@Autowired
	EmployeeRepository emprep;

	public String insertEmployee(Employee e) {

		emprep.save(e);
		return "Success";

	}
	public String insertEmployee(List<Employee> emp) {
				emprep.saveAll(emp);
				return "Success";
	}
	public Employee findEmployee(@PathVariable int e1) {
		
    return emprep.findById(e1).get();


}
	public  List<Employee >findAllEmployee() {
		
	    return emprep.findAll();


	}
	public String deleteEmployee(@PathVariable int e2) {
		emprep.deleteById(e2);
		return "delete Successfully";
	}
	public Employee updateEmployee(Employee e1) {
		return emprep.save(e1);
	}
	public String ageadd(Employee e) {
		if(e.getAge()>=18) {
			emprep.save(e);
			return "Eligible";
		}
		else {
			return "Not Eligible";
		}
	}
	
}

