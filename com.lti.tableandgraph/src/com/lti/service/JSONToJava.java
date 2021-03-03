package com.lti.service;
import com.google.gson.Gson;
import com.lti.model.Employee;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class JSONToJava {

    public static void main(String[] args) {
    	
    	Employee estaff = new Employee();
    	estaff = getEmployeeObject();
    	System.out.println(estaff);
    
    }

    private static Employee getEmployeeObject()
    {
    	 Employee estaff = null;
       try (Reader reader = new FileReader("C:\\Users\\SHIVAPRASAD\\Desktop\\employeesstaff.json")) {
    	   Gson gson = new Gson();
           

            // Convert JSON File to Java Object
             estaff = gson.fromJson(reader, Employee.class);
            
           
        } catch (IOException e) {
            e.printStackTrace();
        }
	return estaff;

            
    }
}
