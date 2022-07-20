package com.arikaran.service;

import java.util.List;



import com.arikaran.model.Employee;

public interface EmployeeService {
      public Employee saveEmployee(Employee e) ;
      public Employee getEmployee(int id);
      public List<Employee> getAllEmployee();
      public void deleteEmployee(int id);
      public Employee UpdateEmployee(Employee e);
      public void DeleteAll();
      public List<Employee>findByName(String name);
      public List<Employee>findByNameAndLocation(String name,String location);
}
