package com.stl.hospitalmanagment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="phone_number")
	private long phone;
	@Column(name="Health_issue")
	private String problem;
	@Column(name="date")
	private String date;

}
