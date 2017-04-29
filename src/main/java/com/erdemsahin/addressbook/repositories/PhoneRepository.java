package com.erdemsahin.addressbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdemsahin.addressbook.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
