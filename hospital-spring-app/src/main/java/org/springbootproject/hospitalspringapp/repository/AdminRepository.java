package org.springbootproject.hospitalspringapp.repository;

import org.springbootproject.hospitalspringapp.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.phone=?1 and a.password=?2")
	Admin verifyAdmin(long phone, String password);
}
