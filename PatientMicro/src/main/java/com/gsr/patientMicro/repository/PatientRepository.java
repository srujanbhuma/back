package com.gsr.patientMicro.repository;
//
//public interface PatientRepository {
//
//}
//package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.gsr.patientMicro.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {

	//Employee save(Employee employee);

	

}

