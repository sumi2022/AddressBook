package com.erdemsahin.addressbook.controllers;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erdemsahin.addressbook.entities.Person;
import com.erdemsahin.addressbook.services.PersonService;


@Component
@Scope("session")
public class PersonController {
	
	@Autowired PersonService personService;
	
	private Person editPerson;
	private Person newPerson;

	public List<Person> getPersons() {
		return personService.findAllPersons();
	}
	
	public void deletePerson(Person person) {
		personService.deletePerson(person.getId());
	}
	
	public void createPerson() throws IOException {
		personService.createPerson(newPerson);
		newPerson=null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
	}
	
	public void updatePerson() throws IOException {
		personService.updatePerson(editPerson);
		editPerson = null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
	}
		
	public Person getNewPerson() {
		if(newPerson == null){
			newPerson = new Person();
		}
		return newPerson;
	}
	
	public void setNewPerson(Person newPerson) {
		this.newPerson = newPerson;
	}
	
	public Person getEditPerson() {
		return editPerson;
	}
	
	public void setEditPerson(Person editPerson) {
		this.editPerson = editPerson;
	}
	
	public String listData(Person person) {
		JSFUtils.setPerson(person);
		return "/editdata?faces-redirect=true";
	}
	
}
