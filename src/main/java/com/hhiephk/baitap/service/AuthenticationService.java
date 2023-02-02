package com.hhiephk.baitap.service;

import com.hhiephk.baitap.model.payload.request.AuthenticationRequest;
import com.hhiephk.baitap.model.payload.request.RegisterRequest;
import com.hhiephk.baitap.model.payload.response.AuthenticationResponse;

public interface AuthenticationService {

	AuthenticationResponse authenticate(AuthenticationRequest request);

	AuthenticationResponse register(RegisterRequest request);

}
