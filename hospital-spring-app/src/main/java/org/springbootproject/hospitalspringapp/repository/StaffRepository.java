package org.springbootproject.hospitalspringapp.repository;

import org.springbootproject.hospitalspringapp.dto.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	@Query("select s from Staff s where s.phone=?1 and s.password=?2")
	Staff verifyStaff(long phone, String password);
}
