package com.gsr.patientMicro.service;
//
//public interface PatientService {
//
//}


import java.util.List;

import com.gsr.patientMicro.model.Patient;



public interface PatientService {
	Patient savePatient(Patient patient);
	List<Patient> getAllPatients();
	Patient getPatientById(long id);
	Patient updatePatient(Patient patient, long id);
	void deletePatient(long id);

}

