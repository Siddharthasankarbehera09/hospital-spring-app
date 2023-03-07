package org.springbootproject.hospitalspringapp.controller;

import java.util.List;

import org.springbootproject.hospitalspringapp.dto.Person;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springbootproject.hospitalspringapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	PersonService service;

	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updateUser(@RequestBody Person person) {
		return service.updatePerson(person);
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deletePerson(id);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<Person>> findPersonById(@PathVariable int id) {
		return service.findPersonById(id);
	}

	@GetMapping("/person/all")
	public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons() {
		return service.findAllPersons();
	}
}
