package com.stl.hospitalmanagment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.hospitalmanagment.model.HospitalUser;

public interface HospitalRepository extends JpaRepository<HospitalUser, Long>{

	Optional<HospitalUser> findByEmail(String email);
	
	

}
