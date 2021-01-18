package com.vinod.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vinod.entity.Salary;
@Repository
public interface SalaryRepo extends MongoRepository<Salary, Integer> {

}
