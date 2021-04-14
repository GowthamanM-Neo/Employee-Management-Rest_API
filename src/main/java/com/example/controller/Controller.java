package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmployeeModel;
import com.example.repository.EmployeeRepository;

@RestController
public class Controller {
	
	@Autowired
	EmployeeRepository EmployeeRepo;
	
	
	//save an employee
	@PostMapping("/addEmployee")
	public void saveEmployee(@RequestBody EmployeeModel employee) {
		EmployeeRepo.save(employee);
	}
	
	//delete an employee
	@GetMapping("/deleteEmployee")
	public void deleteEmployee(@RequestParam(name="id") String id) {
		EmployeeRepo.deleteById(id);
	}
	
	//get all employee
	@GetMapping("/getAllEmployee")
	public List<EmployeeModel> getAllEmployees() {
		return (List<EmployeeModel>) EmployeeRepo.findAll();
	}
	
	//get an individual employee
	@GetMapping("/getEmployee")
	public Optional<EmployeeModel> getEmployee(@RequestParam(name="id") String id) {
		return EmployeeRepo.findById(id);
	}
	
	
}
