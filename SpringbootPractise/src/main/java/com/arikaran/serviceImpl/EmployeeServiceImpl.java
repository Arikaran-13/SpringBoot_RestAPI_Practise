package com.arikaran.serviceImpl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arikaran.model.Employee;
import com.arikaran.repository.EmployeeRepository;
import com.arikaran.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository emprepo;
	@Override
	public Employee saveEmployee(Employee e) {
		return emprepo.save(e);
	}
	@Override
	public Employee getEmployee(int id) {
		
		return emprepo.findById(id).get();	
		}
	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}
	@Override
	public void deleteEmployee(int id) {
		
		emprepo.deleteById(id);
		
	}
	@Override
	public Employee UpdateEmployee(Employee e) {
		
		return emprepo.save(e);
		
	}
	@Override
	public void DeleteAll() {
		emprepo.deleteAll();
		
		
	}
	@Override
	public List<Employee> findByName(String name) {
		
		return emprepo.findByName(name);
	}
	@Override
	public List<Employee> findByNameAndLocation(String name,String loc) {
		return emprepo.findByNameAndLocation(name, loc);
	}
	
	

	
	
}
