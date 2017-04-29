package com.erdemsahin.addressbook.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erdemsahin.addressbook.entities.Address;
import com.erdemsahin.addressbook.services.AddressService;

@Component
@Scope("session")
public class AddressController {

	@Autowired AddressService addressService;
	
	private Address editAddress;
	private Address newAddress;
	private List<Address> addressList = null;
	
	@PostConstruct
	public void init() {
		addressList = getPersonAddresses();
	}
	
	
	public void deleteAddress(Address address) {
		addressService.deleteAddress(address);
		addressList = getPersonAddresses();
	}
	
	public void createAddress() throws IOException {
		addressService.createAddress(getPersonId(), newAddress);
		addressList = getPersonAddresses();
		newAddress=null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("editdata.jsf");
	}
	
	public void updateAddress() throws IOException {
		addressService.updateAddress(editAddress);
		addressList = getPersonAddresses();
		editAddress = null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("editdata.jsf");
	}
	
	public List<Address> getPersonAddresses() {
		return addressService.findPersonAddresses(getPersonId());
	}
	
	public int getPersonId() {
		return JSFUtils.getPerson().getId();
	}
	
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	public List<Address> getAddressList() {
		addressList = addressService.findPersonAddresses(JSFUtils.getPerson().getId());
		return addressList;
	}
	
	public Address getEditAddress() {
		return editAddress;
	}
	
	public void setEditAddress(Address editAddress) {
		this.editAddress = editAddress;
	}
	
	public Address getNewAddress() {
		if(newAddress == null){
			newAddress = new Address();
		}
		return newAddress;
	}
	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}
}
