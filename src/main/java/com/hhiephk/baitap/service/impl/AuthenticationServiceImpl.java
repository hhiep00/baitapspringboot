package com.hhiephk.baitap.service.impl;


import lombok.RequiredArgsConstructor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hhiephk.baitap.constants.Role;
import com.hhiephk.baitap.model.entity.Person;
import com.hhiephk.baitap.model.payload.request.AuthenticationRequest;
import com.hhiephk.baitap.model.payload.request.RegisterRequest;
import com.hhiephk.baitap.model.payload.response.AuthenticationResponse;
import com.hhiephk.baitap.service.AuthenticationService;
import com.hhiephk.baitap.service.JwtService;
import com.hhiephk.baitap.service.PersonService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private PersonService personService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public AuthenticationResponse register(RegisterRequest request) {
//		var user = Person.builder().firstname(request.getFirstname()).lastname(request.getLastname())
//				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(com.baitap.constants.Role.USER)
//				.build();
		Person person = new Person(request.getEmail(), request.getName(), request.getDob(), request.getUsername(),
				passwordEncoder.encode(request.getPassword()), new Date(), new Date(), request.getStatus(), Role.USER);
		personService.save(person);
		var jwtToken = jwtService.generateToken(person);
		return new AuthenticationResponse(jwtToken);
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Person person = personService.findByUsername(request.getUsername()).orElseThrow();
		var jwtToken = jwtService.generateToken(person);
		return new AuthenticationResponse(jwtToken);
	}

}