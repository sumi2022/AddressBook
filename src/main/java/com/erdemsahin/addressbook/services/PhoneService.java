package com.erdemsahin.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erdemsahin.addressbook.entities.Phone;
import com.erdemsahin.addressbook.entities.Person;
import com.erdemsahin.addressbook.repositories.PhoneRepository;
import com.erdemsahin.addressbook.repositories.PersonRepository;

@Service
@Transactional
public class PhoneService {
	
	@Autowired private PersonRepository personRepository;
	@Autowired private PhoneRepository phoneRepository;
	
	public Phone createPhone(Integer personID, Phone phone) {
		Person person = personRepository.findOne(personID);
		phone.setPerson(new Person(personID));
		person.getPhones().add(phone);
		return phone;
	}
	
	public List<Phone> findPersonPhones(Integer personID) {
		Person person = personRepository.findOne(personID);
		return person.getPhones();
	}
	
	public List<Phone> searchPersonPhones(Integer personID, String query) {
		Person person = personRepository.findOne(personID);
		return person.getPhones();
	}
	
	public Phone findPhone(int phoneID) {
		return phoneRepository.findOne(phoneID);
	}
	
	public Phone updatePhone(Phone phone) {
		return phoneRepository.save(phone);
	}
	
	public void deletePhone(Phone phone) {
		phone.setPerson(null);
		phoneRepository.delete(phone.getId());
	}
	
	public void deleteAllPhones(int personID) {
		Person person = personRepository.findOne(personID);
		person.getPhones().clear();
	}
}
