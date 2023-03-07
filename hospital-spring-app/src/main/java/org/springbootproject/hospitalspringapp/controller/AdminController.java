package org.springbootproject.hospitalspringapp.controller;

import java.util.List;

import org.springbootproject.hospitalspringapp.dto.Admin;
import org.springbootproject.hospitalspringapp.dto.ResponseStructure;
import org.springbootproject.hospitalspringapp.service.AdminService;
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
public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateUser(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteAdmin(id);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id) {
		return service.findAdminById(id);
	}

	@GetMapping("/admin/all")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmins() {
		return service.findAllAdmins();
	}

	@PostMapping("/admin/verify")
	public ResponseEntity<ResponseStructure<Admin>> verifyUser(@RequestParam long phone,
			@RequestParam String password) {
		return service.verifyAdmin(phone, password);
	}
}
