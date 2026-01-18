package com.azad.hello.controller;

import com.azad.hello.dto.AuthResponseDto;
import com.azad.hello.dto.LoginRequestDto;
import com.azad.hello.dto.RegistrationRequestDto;
import com.azad.hello.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegistrationRequestDto registrationRequestDto){
        return ResponseEntity.ok(authService.register(registrationRequestDto));
    }

    @PostMapping("/singin")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));

    }
}
