package com.arikaran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arikaran.model.Employee;
import com.arikaran.service.EmployeeService;

@RestController
public class EmployeeServletController {
	
	@Autowired
	EmployeeService eService;
     
	@GetMapping("/index")
	public String getInfo() {
		return "hello welcome to restAPI";
	}
	
	@GetMapping("/employee")
	public Employee EmpDetails() {
		
		return  new Employee(1, "Arikaran", "chennai");
	}
	@PostMapping("/employee")
	public Employee PostEmployee(@RequestBody Employee e) {
		
		return eService.saveEmployee(e);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id")int id) {
		
		return eService.getEmployee(id);
	}
	@GetMapping("/employeelist")
	public List<Employee>getAllEmployee(){
		
		return eService.getAllEmployee();
	}
	@DeleteMapping("delete/{id}")       
	public void DeleteEmployee(@PathVariable("id")int id) {
		eService.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	public Employee UpdateEmployee(@RequestBody Employee e) {
		return eService.UpdateEmployee(e);
	}
	@GetMapping("employees/findByName")
	public ResponseEntity<List<Employee>>FindByName(@RequestParam("name") String name){
		
		return new ResponseEntity<List<Employee>> (eService.findByName(name),HttpStatus.OK);
	}
	@GetMapping("employee/filternameAndLocation")
	public ResponseEntity<List<Employee> >findByNameAndLocation(@RequestParam("name")String name,@RequestParam("location")String location)

	{
		return new ResponseEntity<List<Employee>>(eService.findByNameAndLocation(name, location),HttpStatus.OK);
	}
}









