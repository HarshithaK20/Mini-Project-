package com.myproject.Sales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.Sales.Model.Customer;
import com.myproject.Sales.Model.OrderList;
import com.myproject.Sales.Model.Product;
import com.myproject.Sales.Repository.CustomerRepository;
import com.myproject.Sales.Repository.OrderListRepository;
import com.myproject.Sales.Repository.ProductRepository;

@RestController
public class SalesController {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderListRepository orderListRepository;
	
	
	@RequestMapping("/helloWorld")
	public String helloWorld()
	{
		return "hello";
	}

	@GetMapping("/customer/getall")
	public List<Customer> GetAll()
	{
		return customerRepository.findAll();
	}
	
	@GetMapping("/getproduct")
	public List<Product> GetProduct()
	{
		return productRepository.findAll();
	}
	
	@GetMapping("/getorder")
	public List<OrderList> GetOrder()
	{
		return orderListRepository.findAll();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody OrderList order)
	{
		String oid=order.getOid();
		if(orderListRepository.existsById(oid))
			return "Order\t"+oid+"\talready Exist";
		else
		{
			Customer customer=order.getCustomer();
			Product product=order.getProduct();
			String TotalPrice=order.getTotalprice();
			int cid=customer.getId();
			String pid=product.getPid();
			if(customerRepository.existsById(cid)&&productRepository.existsById(pid))
			{
				orderListRepository.save(new OrderList(oid,TotalPrice,customer,product));
				return "Order Successful";
		
			}
			else
			{
				return "Cid and Pid doesn't exist";
			}
		}


	}
	
	@DeleteMapping("/delete/{oid}")
	public String delete(@PathVariable(value="oid")String oid) 
	{
		
		orderListRepository.deleteById(oid);
		return "deleted";
	}
	
	@PutMapping("/update")
	public OrderList update(@RequestBody OrderList order)
	{
		String id=order.getOid();
		orderListRepository.findById(id);
		return orderListRepository.save(order);
	}
	
   

}