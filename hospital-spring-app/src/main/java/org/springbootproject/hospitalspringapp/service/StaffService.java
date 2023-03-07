package org.springbootproject.hospitalspringapp.service;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dao.StaffDao;
import org.springbootproject.hospitalspringapp.dto.Staff;
import org.springbootproject.hospitalspringapp.exception.IdNotFoundException;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StaffService {
	@Autowired
	StaffDao dao;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		structure.setMessage("Staff is saved");
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setBody(dao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		structure.setBody(dao.updateStaff(staff));
		structure.setMessage("staff updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteStaff(@PathVariable int id) {
		Optional<Staff> recStaff = dao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recStaff.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Staff Found");
			structure.setMessage("Staff Found and Deleted");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Staff>> findStaffById(@PathVariable int id) {
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		Optional<Staff> recStaff = dao.findById(id);
		if (recStaff.isPresent()) {
			structure.setBody(recStaff.get());
			structure.setMessage("Staff Found");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaffs() {
		ResponseStructure<List<Staff>> structure = new ResponseStructure<List<Staff>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Staffs");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Staff>> verifyStaff(@RequestParam long phone,
			@RequestParam String password) {
		Staff u = dao.verifyStaff(phone, password);
		ResponseStructure<Staff> structure = new ResponseStructure<Staff>();
		if (u != null) {
			structure.setMessage("staff has been verified");
			structure.setBody(u);
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}
}
