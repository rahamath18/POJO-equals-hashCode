package com.test.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestCustomer {
	
	public static void main(String[] args) {
		
		Customer cust0 = new Customer(4, "Smith", "smith@yahoo.com");
		Customer cust1 = new Customer(1, "rahamath", "rahamath18@yahoo.com");
		Customer cust2 = new Customer(1, "rahamath", "rahamath18@yahoo.com");
		Customer cust3 = new Customer(3, "John", "john@yahoo.com");
		Customer cust4 = new Customer(2, "Adam", "adam@yahoo.com");
		
		// just comapre two customer objects
		System.out.println(cust1.equals(cust2)); // print true as overridden the equals method
		System.out.println(cust1.equals(cust3)); // print false as overridden the equals method
		
		
		// store all 4 customers objects into List
		List<Customer> aList = new ArrayList<Customer>();
		aList.add(cust0);
		aList.add(cust1);
		aList.add(cust2);
		aList.add(cust3);
		aList.add(cust4);
		System.out.println(aList); // print customer objects in insertion order
		
		Collections.sort(aList);
		System.out.println(aList); // print customer objects in ascending by customer.id order as overridden the equals method
		
		Collections.sort(aList, Customer.nameComparator);
		System.out.println(aList); // print customer objects in ascending order by customer.name as given Comparator for Customer.name

		
		// store all 4 customers objects into Map
		Map<Customer, String> aMap = new HashMap<Customer, String>();
		aMap.put(cust0, "004");
		aMap.put(cust1, "001");
		aMap.put(cust2, "001");
		aMap.put(cust3, "002");
		aMap.put(cust4, "003");
		System.out.println(aMap); // print customer objects with removing duplicate customer details as overridden hashCode()
		
		Map<Customer, String> aTreeMap = new TreeMap<>(Customer.nameComparator);
		aTreeMap.putAll(aMap);
		System.out.println(aTreeMap); // print customer objects in ascending order by customer.name as given Comparator for Customer.name

		
		aMap.put(new Customer(-1, "xyz", "adam@yahoo.com"), "-1");
		List<Map.Entry<Customer, String>> list =
                new LinkedList<Map.Entry<Customer, String>>(aMap.entrySet());
		Collections.sort(list, Customer.byValueomparator); // ascending order by value
		System.out.println(list);
		
		
		List<Map.Entry<Customer, String>> list_1 =
                new LinkedList<Map.Entry<Customer, String>>(aMap.entrySet());
		Collections.sort(list_1, Customer.byNameomparator); // descending order by customer.name
		System.out.println(list_1);
		
	}

}
