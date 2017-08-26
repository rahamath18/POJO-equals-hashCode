package com.test.pojo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class Customer implements Serializable, Comparable<Customer> {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
    	Customer cust = (Customer) obj;
    	
    	// before java 7
    	if(cust.getId() == this.id && 
    			cust.getName().equals(this.name) && 
    			cust.getEmail().equals(this.email))
    		return true;
    	else
    		return false;
    	
    	// from java 7
//    	return cust.getId() == this.id &&
//    			Objects.equals(name, cust.name) &&
//    			Objects.equals(email, cust.email);
    }
    
    @Override
    public int hashCode() {
    	
    	// before java 7
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
        
        // from java 7
        // return Objects.hash(id, name, email);
    }
    
    @Override
    public String toString() {
    	return id +"|"+ name +"|"+ email;
    }
    
    /*
     * This can be used while sorting the collection of customers objects 
     * with passing Comparator ref to Collections.sort(aColl)
     */
    @Override
	public int compareTo(Customer e) {
    	
    	final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        
        if (this == e) return EQUAL;
        
		if (this.id > e.id) 
			return AFTER;
		
		if (this.id < e.id) 
			return BEFORE;
		
		return EQUAL;
	}
    
    /*
     * This can be used while sorting the collection of customers objects 
     * with passing Comparator ref to Collections.sort(aColl, Comparator)
     */
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
 		@Override
 		public int compare(Customer c1, Customer c2) {
 			return Integer.valueOf(c1.getId()).compareTo(Integer.valueOf(c2.getId()));
 		}
 	};
    
 	/*
     * This can be used while sorting the collection of customers objects 
     * with passing Comparator ref to Collections.sort(aColl, Comparator)
     */
 	public static Comparator<Customer> nameComparator = new Comparator<Customer>() {
 		@Override
 		public int compare(Customer c1, Customer c2) {
 			return c1.getName().compareTo(c2.getName());
 		}
 	};
 	
 	public static Comparator<Map.Entry<Customer, String>> byValue = new Comparator<Map.Entry<Customer, String>>() {
        public int compare(Map.Entry<Customer, String> o1,
                Map.Entry<Customer, String> o2) {
		 return (o1.getValue().toString()).compareTo(o2.getValue().toString());
		}
 	};

 	
 	// you may add as many Comparator and all about how you want sort or order your POJO
 	
}