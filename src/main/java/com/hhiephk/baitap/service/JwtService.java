package com.hhiephk.baitap.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	boolean isTokenValid(String token, UserDetails userDetails);

	String generateToken(UserDetails userDetails);

	String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

	String extractUsername(String token);

}
