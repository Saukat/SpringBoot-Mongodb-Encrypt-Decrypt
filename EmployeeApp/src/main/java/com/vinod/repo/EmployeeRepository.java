package com.vinod.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vinod.entity.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
