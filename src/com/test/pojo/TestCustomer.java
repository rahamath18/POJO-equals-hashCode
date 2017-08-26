package com.test.pojo;

import java.util.HashMap;
import java.util.Map;

public class TestCustomer {
	
	public static void main(String[] args) {
		
		Customer cust1 = new Customer(1, "rahamath", "rahamath18@yahoo.com");
		Customer cust2 = new Customer(1, "rahamath", "rahamath18@yahoo.com");
		
		System.out.println(cust1.equals(cust2));
		
		Map<Customer, String> aMap = new HashMap<Customer, String>();
		aMap.put(cust1, "1");
		aMap.put(cust2, "2");
		System.out.println(aMap);

	}

}
