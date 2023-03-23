package com.stl.hospitalmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.hospitalmanagment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
