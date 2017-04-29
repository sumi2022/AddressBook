package com.erdemsahin.addressbook.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "personID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "Name", length = 32, nullable = false)
    private String name;

    @Column(name = "Surname", length = 64, nullable = false)
    private String surname;
	
    @Column(name = "Email", length = 64, nullable = false, unique = true)
    private String email;
    
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="person")
    private List<Phone> phones = null;
    
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="person")
    private List<Address> addresses = null;

    public Person() {
    	
    }
    
    public Person(Integer id) {
    	this.id = id;
    }
    
    public Person(Integer id, String name, String surname, String email) {
    	this.id = id;
    	this.name = name;
    	this.surname = surname;
    	this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getPhones() {
    	return phones;
    }
    
    public void setPhones(List<Phone> phones) {
    	this.phones = phones;
    }
    
    public List<Address> getAddresses() {
    	return addresses;
    }
    
    public void setAddresses(List<Address> addresses) {
    	this.addresses = addresses;
    }

}
