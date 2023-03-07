package org.springbootproject.hospitalspringapp.service;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dao.AdminDao;
import org.springbootproject.hospitalspringapp.dto.Admin;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springbootproject.hospitalspringapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdminService {
	@Autowired
	AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setMessage("Admin is saved");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(dao.updateAdmin(admin));
		structure.setMessage("admin updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAdmin(@PathVariable int id) {
		Optional<Admin> recAdmin = dao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recAdmin.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Admin Found");
			structure.setMessage("Admin Found and Deleted");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		Optional<Admin> recAdmin = dao.findById(id);
		if (recAdmin.isPresent()) {
			structure.setBody(recAdmin.get());
			structure.setMessage("Admin Found");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmins() {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Admins");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam long phone,
			@RequestParam String password) {
		Admin u = dao.verifyAdmin(phone, password);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		if (u != null) {
			structure.setMessage("admin has been verified");
			structure.setBody(u);
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}
}
