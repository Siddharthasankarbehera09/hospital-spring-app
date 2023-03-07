package org.springbootproject.hospitalspringapp.dao;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dto.Person;
import org.springbootproject.hospitalspringapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	@Autowired
	PersonRepository repository;

	public Person savePerson(Person person) {
		return repository.save(person);
	}

	public Person updatePerson(Person person) {
		return repository.save(person);
	}

	public Optional<Person> findById(int id) {
		return repository.findById(id);
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
