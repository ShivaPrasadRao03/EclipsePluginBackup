package com.lti.model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	private String employeeID;
   
    private String firstName;
    private String lastName;
    private String employeeDesignation;
    private boolean married;
    private String gender;
    private Integer age;
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
            this);

    public Person() {
    }

    public Person(String employeeID,String firstName, String lastName,String employeeDesignation,String gender) {
           
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.employeeDesignation = employeeDesignation;
        this.gender = gender;
        this.married = married;
    }

    public void addPropertyChangeListener(String propertyName,
            PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    public String getEmployeeID() {
		return employeeID;
	}

	

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	
    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isMarried() {
        return married;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setEmployeeID(String employeeID) {
        propertyChangeSupport.firePropertyChange("EmployeeID", this.employeeID,
                this.employeeID = employeeID);
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        propertyChangeSupport.firePropertyChange("EmployeeDesignation", this.employeeDesignation,
                this.employeeDesignation = employeeDesignation);
    }

 
	public void setGender(String gender) {
        propertyChangeSupport.firePropertyChange("Gender", this.gender,
                this.gender = gender);
    }

	public void setFirstName(String firstName) {
        propertyChangeSupport.firePropertyChange("FirstName", this.firstName,
                this.firstName = firstName);
    }
	
    public void setLastName(String lastName) {
        propertyChangeSupport.firePropertyChange("LastName", this.lastName,
                this.lastName = lastName);
    }

//    public void setMarried(boolean isMarried) {
//        propertyChangeSupport.firePropertyChange("Married", this.married,
//                this.married = isMarried);
//    }

   

    public void setAge(Integer age) {
        propertyChangeSupport.firePropertyChange("Age", this.age,
                this.age = age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
