package org.springbootproject.hospitalspringapp.controller;

import java.util.List;

import org.springbootproject.hospitalspringapp.dto.Staff;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springbootproject.hospitalspringapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
	@Autowired
	StaffService service;

	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}

	@PutMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> updateUser(@RequestBody Staff staff) {
		return service.updateStaff(staff);
	}

	@DeleteMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteStaff(id);
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> findStaffById(@PathVariable int id) {
		return service.findStaffById(id);
	}

	@GetMapping("/staff/all")
	public ResponseEntity<ResponseStructure<List<Staff>>> findAllStaffs() {
		return service.findAllStaffs();
	}

	@PostMapping("/staff/verify")
	public ResponseEntity<ResponseStructure<Staff>> verifyUser(@RequestParam long phone,
			@RequestParam String password) {
		return service.verifyStaff(phone, password);
	}
}
