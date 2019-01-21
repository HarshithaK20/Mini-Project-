package com.myproject.Sales.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myproject.Sales.Model.Customer;
import com.myproject.Sales.Model.OrderList;

@Repository
public interface OrderListRepository extends CrudRepository<OrderList,String> {
	List<OrderList> findAll();

}