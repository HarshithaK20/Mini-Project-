package com.myproject.Sales.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.Sales.Model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {
List<Product> findAll();
}

