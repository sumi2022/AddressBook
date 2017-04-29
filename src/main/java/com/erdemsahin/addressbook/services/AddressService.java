package com.erdemsahin.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erdemsahin.addressbook.entities.Address;
import com.erdemsahin.addressbook.entities.Person;
import com.erdemsahin.addressbook.repositories.AddressRepository;
import com.erdemsahin.addressbook.repositories.PersonRepository;

@Service
@Transactional
public class AddressService {
	
	@Autowired private PersonRepository personRepository;
	@Autowired private AddressRepository addressRepository;
	
	public Address createAddress(Integer personID, Address address) {
		Person person = personRepository.findOne(personID);
		address.setPerson(new Person(personID));
		person.getAddresses().add(address);
		return address;
	}
	
	public List<Address> findPersonAddresses(Integer personID) {
		Person person = personRepository.findOne(personID);
		return person.getAddresses();
	}
	
	public List<Address> searchPersonAddresses(Integer personID, String query) {
		Person person = personRepository.findOne(personID);
		return person.getAddresses();
	}
	
	public Address findAddress(int addressID) {
		return addressRepository.findOne(addressID);
	}
	
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public void deleteAddress(Address address) {
		address.setPerson(null);
		addressRepository.delete(address.getId());
	}
	
	public void deleteAllAddresses(int personID) {
		Person person = personRepository.findOne(personID);
		person.getAddresses().clear();
	}
}
