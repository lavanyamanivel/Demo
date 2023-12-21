package com.example.Employee.Service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Employee.Entity.Employee;
import com.example.Employee.dao.Employeedao;
import com.example.Employee.exception.NameNotFoundException;
import com.example.Employee.exception.SalaryNotFoundException;


@Service

public class EmployeeService {
	@Autowired
	Employeedao empDao;

	public String insertEmployee(Employee e) {
		return empDao.insertEmployee(e);
	}
	public String insertEmployee(List<Employee> emp) {
		return empDao.insertEmployee(emp);
	}
	
	public Employee findEmployee(@PathVariable int e1) {
		return empDao.findEmployee(e1);
	}
	public List<Employee>findAllEmployee() {
		return empDao.findAllEmployee();
	}
	public String deleteEmployee(@PathVariable int e2) {
		return empDao.deleteEmployee(e2);
	}
	
	public Employee updateEmployee(Employee e1) {
		return empDao.updateEmployee(e1);
	}
	public List<Employee>getempgender(String gender) {
		List<Employee>allemp=this.findAllEmployee();
		return allemp.stream().filter(x->x.getGender().equalsIgnoreCase(gender)).toList();
	}
	public List<Employee>getempname(String name) {
		List<Employee>allemp=this.findAllEmployee();
		return allemp.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
	
}
	/*public List<Employee>getsalary(int salary) {
		List<Employee>allemp=this.findAllEmployee();
		return allemp.stream().filter(x->x.getSalary()>salary).toList();
	
}*/
	public List<Employee>getempage(int age) {
		List<Employee>allemp=this.findAllEmployee();
		return allemp.stream().filter(x->x.getAge()>age).toList();
	
}
	public Employee getempmaxsalary() {
		List<Employee>allemp=this.findAllEmployee();
      Employee max=allemp.stream().max(Comparator.comparing(Employee::getSalary)).get();
		return max;
	}
	public Employee getempmaxage() {
		List<Employee>allemp=this.findAllEmployee();
      Employee max=allemp.stream().max(Comparator.comparing(Employee::getAge)).get();
		return max;
	}
	
	
	public String getempmaxsalaryname() {
		List<Employee>allemp=this.findAllEmployee();
      String max=allemp.stream().max(Comparator.comparing(Employee::getSalary)).map(i->i.getName()).get();
		return max;
	
}
	public Integer getempmaxagesalary() {
		List<Employee>allemp=this.findAllEmployee();
      Integer max=allemp.stream().max(Comparator.comparing(Employee::getAge)).map(i->i.getSalary()).get();
		return max;
}
	public List<Employee>getfemalehike() {
		List<Employee>allemp=this.findAllEmployee();
		return allemp.stream().filter(i->i.getGender().equalsIgnoreCase("female")).map(x->{
				int a=x.getSalary()+x.getSalary()*5/100;
		x.setSalary(a);
		return x;
		}).toList();
		}
	public String ageadd(Employee e) {
		return empDao.ageadd(e);
		
	}
	public List<Employee>getempsalary(int salary)throws SalaryNotFoundException {
		List<Employee>allemp=this.findAllEmployee();
		List<Employee>val=allemp.stream().filter(x->x.getSalary()>=salary).toList();
		if(val.isEmpty()==true) {
			throw new SalaryNotFoundException("there is no data in this salary");
		}
		else {
			return val;
		}
	}

		public List<Employee>getempbyname(String name)throws NameNotFoundException {
			List<Employee>allemp=this.findAllEmployee();
			List<Employee>val=allemp.stream().filter(x->x.getName().equals(name)).toList();
			if(val.isEmpty()==true) {
				throw new NameNotFoundException("there is no data in this name");
			}
			else {
				return val;
			}
	}
}

	


