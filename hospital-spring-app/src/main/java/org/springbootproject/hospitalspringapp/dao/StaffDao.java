package org.springbootproject.hospitalspringapp.dao;

import java.util.List;
import java.util.Optional;

import org.springbootproject.hospitalspringapp.dto.Staff;
import org.springbootproject.hospitalspringapp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDao {
	@Autowired
	StaffRepository repository;

	public Staff saveStaff(Staff staff) {
		return repository.save(staff);
	}

	public Staff updateStaff(Staff staff) {
		return repository.save(staff);
	}

	public Optional<Staff> findById(int id) {
		return repository.findById(id);
	}

	public List<Staff> findAll() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Staff verifyStaff(long phone, String password) {
		return repository.verifyStaff(phone, password);
	}
}
