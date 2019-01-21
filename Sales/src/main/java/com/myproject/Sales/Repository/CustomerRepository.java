package com.myproject.Sales.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.Sales.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	
	List<Customer> findAll();

}
