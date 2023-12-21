package com.example.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.EmployeeService;
import com.example.Employee.exception.SalaryNotFoundException;
@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empSer;
	
	@PostMapping(value="/add")
	public String insertEmployee(@RequestBody Employee e) {
		return empSer.insertEmployee(e);
	}
	
	@PostMapping(value="/List")
	public String insertEmployee(@RequestBody List<Employee> emp) {
		return empSer.insertEmployee(emp);
	}
	@GetMapping(value="/find/{e1}")
	public Employee finfEmployee(@PathVariable int e1) {
		return empSer.findEmployee(e1);
	}
	@GetMapping(value="/findall")
	public List<Employee>findAllEmployee() {
		return empSer.findAllEmployee();
	}
	@GetMapping(value="/removeById/{e2}")
	public String deleteEmployee(@PathVariable int e2) {
		return empSer.deleteEmployee(e2);
	}
	@PutMapping(value="/update")
	public Employee  updateEmployee(@RequestBody Employee e1) {
		return empSer.updateEmployee(e1);
	}
	@GetMapping(value="/getbygender/{gender}")
	public List<Employee> getempgender(@PathVariable String gender) {

     return empSer.getempgender(gender);
	
	
	}
	//@GetMapping(value="/getbyname/{name}")
	//public List<Employee> getempname(@PathVariable String name) {

     //return empSer.getempname(name);
	
//}
	@GetMapping(value="/getbysalary/{salary}")
	public List<Employee> getempsalary(@PathVariable int salary)throws SalaryNotFoundException  {

     return empSer.getempsalary(salary);
	
}
	@GetMapping(value="/getbyage/{age}")
	public List<Employee> getempage(@PathVariable int age) {

     return empSer.getempage(age);
	
	
}
	@GetMapping(value="/getbymaxsalary")
	public Employee getempmaxsalary() {

      return empSer. getempmaxsalary();
	
	
}
	@GetMapping(value="/getbymaxage")
	public Employee getempmaxage() {

      return empSer. getempmaxage();
	}
	

	@GetMapping(value="/getbymaxsalaryname")
	public String getempmaxsalaryname() {

     return empSer.getempmaxsalaryname();
	
}
	

	@GetMapping(value="/getbymaxagesalary")
	public Integer getempmaxagesalary() {

     return empSer.getempmaxagesalary();
     
}
	@GetMapping(value="/femalehike")
	public List<Employee>getfemalehike() {
		return empSer.getfemalehike();
	}
	
	@PostMapping(value="/age")
	public  String ageadd(@RequestBody Employee e) {
		return empSer.ageadd(e);
	}
	
	
}

	
