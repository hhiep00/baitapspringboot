package com.hhiephk.baitap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhiephk.baitap.model.payload.request.AuthenticationRequest;
import com.hhiephk.baitap.model.payload.request.RegisterRequest;
import com.hhiephk.baitap.model.payload.response.AuthenticationResponse;
import com.hhiephk.baitap.service.AuthenticationService;
import com.hhiephk.baitap.service.EmailSenderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private AuthenticationService service;
	@Autowired
	private EmailSenderService emailSenderService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest request) {
		emailSenderService.sendEmail(request.getEmail(), "Register successfully", "Register successfully");
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}
}