package com.gsr.patientMicro.controller;
//
//public class PatientController {
//
//}

//package com.example.springboot.controller;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.springboot.model.Employee;
//import com.example.springboot.service.EmployeeService;
import com.gsr.patientMicro.model.Patient;
import com.gsr.patientMicro.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	//build create employee REST API
	@PostMapping()  
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED );	
	}
	// build  get all employee REST API
	@GetMapping
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
		
		
	}
	
	// build get employee by id REST API
	// http://localhost:8088/api/employees/1
	@GetMapping("{id}")// inside this {} is dynamic 
	public ResponseEntity<Patient> getEmployeeById(@PathVariable("id") long patientId){
		return new ResponseEntity<Patient>(patientService.getPatientById(patientId), HttpStatus.OK);	
	}
	
	// build update employee REST API
	// http://localhost:8088/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id,@RequestBody Patient patient){
		return  new  ResponseEntity<Patient>(patientService.updatePatient(patient, id), HttpStatus.OK);
		
	}
	// build delete employee REST API
	// http://localhost:8088/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		// delete employee from DB
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Patient deleted successfully!.", HttpStatus.OK);
	}
	
	
	 

}

