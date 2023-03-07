package org.springbootproject.hospitalspringapp.repository;

import org.springbootproject.hospitalspringapp.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
