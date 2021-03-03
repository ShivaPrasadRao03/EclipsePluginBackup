package com.lti.model;


import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
    INSTANCE;

    private List<Person> persons;

    private ModelProvider() {
        persons = new ArrayList<Person>();
        // Image here some fancy database access to read the persons and to
        // put them into the model
        
        persons.add(new Person("EMP1","Software Engineer","M", "Suresh", "Male"));
        persons.add(new Person("EMP2","Senior Software Engineer","G", "Shiva Prasad", "Male"));
        persons.add(new Person("EMP3","Project Manager","k", "Harika", "Female"));
        persons.add(new Person("EMP4","Delivery Manager","P", "Ramesh", "Male"));
        persons.add(new Person("EMP5","VicePresident", "N", "Sowmya","Female"));
    }

    public List<Person> getPersons() {
        return persons;
    }

}
