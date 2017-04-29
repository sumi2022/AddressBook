package com.erdemsahin.addressbook.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erdemsahin.addressbook.entities.Phone;
import com.erdemsahin.addressbook.services.PhoneService;

@Component
@Scope("session")
public class PhoneController {

	@Autowired PhoneService phoneService;
	
	private Phone editPhone;
	private Phone newPhone;
	private List<Phone> phoneList = null;
	
	@PostConstruct
	public void init() {
		phoneList = getPersonPhones();
	}
	
	
	public void deletePhone(Phone phone) {
		phoneService.deletePhone(phone);
		phoneList = getPersonPhones();
	}
	
	public void createPhone() throws IOException {
		phoneService.createPhone(getPersonId(), newPhone);
		phoneList = getPersonPhones();
		newPhone=null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("editdata.jsf");
	}
	
	public void updatePhone() throws IOException {
		phoneService.updatePhone(editPhone);
		phoneList = getPersonPhones();
		editPhone = null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("editdata.jsf");
	}
	
	public List<Phone> getPersonPhones() {
		return phoneService.findPersonPhones(getPersonId());
	}
	
	public int getPersonId() {
		return JSFUtils.getPerson().getId();
	}
	
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	public List<Phone> getPhoneList() {
		phoneList = phoneService.findPersonPhones(JSFUtils.getPerson().getId());
		return phoneList;
	}
	
	public Phone getEditPhone() {
		return editPhone;
	}
	
	public void setEditPhone(Phone editPhone) {
		this.editPhone = editPhone;
	}
	
	public Phone getNewPhone() {
		if(newPhone == null){
			newPhone = new Phone();
		}
		return newPhone;
	}
	public void setNewPhone(Phone newPhone) {
		this.newPhone = newPhone;
	}
}
