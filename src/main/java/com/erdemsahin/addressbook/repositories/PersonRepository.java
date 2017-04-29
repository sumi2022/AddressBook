package com.erdemsahin.addressbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdemsahin.addressbook.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
