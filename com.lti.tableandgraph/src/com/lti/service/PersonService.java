
package com.lti.service;
import com.lti.model.*;

public interface PersonService {

	public boolean addPerson(Person p);
	
	public boolean deletePerson(int id);
	
	public Person getPersons(int id);
	
	public Person[] getAllPersons();
}
