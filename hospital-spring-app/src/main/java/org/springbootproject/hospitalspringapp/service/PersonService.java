package org.springbootproject.hospitalspringapp.service;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dao.PersonDao;
import org.springbootproject.hospitalspringapp.dto.Person;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springbootproject.hospitalspringapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
	@Autowired
	PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		structure.setMessage("Person is saved");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		structure.setBody(dao.updatePerson(person));
		structure.setMessage("person updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deletePerson(@PathVariable int id) {
		Optional<Person> recPerson = dao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recPerson.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Person Found");
			structure.setMessage("Person Found and Deleted");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonById(@PathVariable int id) {
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		Optional<Person> recUser = dao.findById(id);
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("Person Found");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons() {
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Persons");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.OK);
	}

}
