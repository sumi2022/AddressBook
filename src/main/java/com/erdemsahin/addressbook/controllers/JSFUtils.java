package com.erdemsahin.addressbook.controllers;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.erdemsahin.addressbook.entities.Person;

public final class JSFUtils {
	
	public static void setPerson(Person person)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("SELECT_PERSON", person);
	}
	
	public static Person getPerson()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		return (Person) session.getAttribute("SELECT_PERSON");
	}
	
}
