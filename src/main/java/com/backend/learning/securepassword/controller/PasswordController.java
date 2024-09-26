package com.backend.learning.securepassword.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.learning.securepassword.dto.FailureResponse;
import com.backend.learning.securepassword.dto.PasswordRequest;
import com.backend.learning.securepassword.service.PasswordService;

@RestController
public class PasswordController {

	private final PasswordService passwordService;

	public PasswordController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@PostMapping(value = "/validate-password")
	public ResponseEntity<FailureResponse> validatePassword(@RequestBody PasswordRequest request) {

		var failures = passwordService.validatePass(request.password());

		if (failures.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.badRequest().body(new FailureResponse(failures));

	}
}
