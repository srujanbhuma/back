package com.stl.hospitalmanagment.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.hospitalmanagment.config.JwtService;
import com.stl.hospitalmanagment.model.Appointment;
import com.stl.hospitalmanagment.model.HospitalUser;
import com.stl.hospitalmanagment.model.Role;
import com.stl.hospitalmanagment.repository.AppointmentRepository;
import com.stl.hospitalmanagment.repository.HospitalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	  private final HospitalRepository repository;
	  public final AppointmentRepository aRepository;
	  private final PasswordEncoder passwordEncoder;
	  private final JwtService jwtService;
	  private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		
		var hospitalUser =HospitalUser.builder()
							.firstName(request.getFirstName())
							.lastName(request.getLastName())
							.email(request.getEmail())
							.password(passwordEncoder.encode(request.getPassword()))
							.role(Role.PATIENT)
							.build();
		repository.save(hospitalUser);
		var jwtToken = jwtService.generateToken(hospitalUser);
	    return AuthenticationResponse.builder()
	        .token(jwtToken)
	        .build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		 authenticationManager.authenticate(
			        new UsernamePasswordAuthenticationToken(
			            request.getEmail(),
			            request.getPassword()
			        )
			    );
			    var hospitalUser = repository.findByEmail(request.getEmail())
			        .orElseThrow();
			    var jwtToken = jwtService.generateToken(hospitalUser);
			    return AuthenticationResponse.builder()
			            .token(jwtToken)
			            .build();
	}

	public Appointment registerAppointment(Appointment appointment) {
		return aRepository.save(appointment);
	}
	
	

}
