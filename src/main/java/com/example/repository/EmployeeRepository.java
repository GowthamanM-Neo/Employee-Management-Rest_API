package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, String>{

}
