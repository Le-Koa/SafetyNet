package com.safetynetalert.apiAlert.repository;

import com.safetynetalert.apiAlert.Model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    List<Person> findDistinctByAddress(String address);

    List<Person> findByLastName(String lastName);

    List<Person> findByCity(String city);

    List<Person> findAllByAddressInOrderByAddress(List<String> addressList);

    List<Person> findByFirstNameAndLastNameAllIgnoreCase (String firstName, String lastName);

    boolean existsByfirstNameAndLastName(String firstName, String lastName);

    boolean existsById (Long id);

    boolean existsByCity (String city);

    boolean existsByAddress (String address);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    void deletePersonByFirstNameAndLastNameAllIgnoreCase (String firstName, String lastName);


}
