package com.gsr.patientMicro.serviceimpl;
//
//public class PatientServiceImpl {
//
//}


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.gsr.patientMicro.repository;
import com.gsr.patientMicro.exception.ResourceNotFoundException;
import com.gsr.patientMicro.model.Patient;
import com.gsr.patientMicro.repository.PatientRepository;
import com.gsr.patientMicro.service.PatientService;

//import com.gsr.springboot.exception.ResourceNotFoundException;
//import com.example.springboot.model.Employee;
//import com.example.springboot.repository.EmployeeRepository;
//import com.example.springboot.service.EmployeeService;

@Service

public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
	    
    
    public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepository.save(patient);
		
	}
	@Override
	public List<Patient> getAllPatients() {
		
		return patientRepository.findAll();
	}
	
	@Override
	public Patient getPatientById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//			
//			
//		}
//		else {
	//		throw  new ResourceNotFoundException("Employee", "Id", id);
//		}

		return  patientRepository.findById(id).orElseThrow(() -> 
		                new ResourceNotFoundException("Patient","Id",id));
		
	}
	@Override
	public Patient updatePatient(Patient patient, long id) {
	     // we need to check whether employee with given id is exist in DB or not
		Patient existingPatient = patientRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "Id", id));
		
		existingPatient.setpName(patient.getpName());
		//existingPatient.setLastName(patient.getLastName());
		existingPatient.setEmail(patient.getEmail());
		// save existing Patient to DB
		patientRepository.save(existingPatient);
		
		return existingPatient;
	}
	@Override
	public void deletePatient(long id) {
		
		// check whether a employee exist in DB or not
		patientRepository.findById(id).orElseThrow(() ->
		                        new ResourceNotFoundException("Patient", "Id",id));		
		patientRepository.deleteById(id);
		
	}
	
	

}
