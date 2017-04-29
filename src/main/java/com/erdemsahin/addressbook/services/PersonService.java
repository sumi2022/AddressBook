package com.erdemsahin.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erdemsahin.addressbook.entities.Person;
import com.erdemsahin.addressbook.repositories.PersonRepository;

@Service
@Transactional
public class PersonService {
	
	@Autowired private PersonRepository personRepository;
	
	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}
	
	public Person findPersonById(Integer personID) {
		return personRepository.findOne(personID);
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	
	public void deletePerson(int personID) {
		personRepository.delete(personID);
	}
}
