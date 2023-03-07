package org.springbootproject.hospitalspringapp.dao;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dto.Admin;
import org.springbootproject.hospitalspringapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository repository;

	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Admin updateAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Optional<Admin> findById(int id) {
		return repository.findById(id);
	}

	public List<Admin> findAll() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Admin verifyAdmin(long phone, String password) {
		return repository.verifyAdmin(phone, password);
	}

}
