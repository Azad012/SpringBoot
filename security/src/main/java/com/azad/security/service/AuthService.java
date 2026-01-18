package com.azad.security.service;

import com.azad.security.dto.AuthResponseDto;
import com.azad.security.dto.LoginRequestDto;
import com.azad.security.dto.RegistrationRequestDto;
import com.azad.security.entity.User;
import com.azad.security.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDto register(RegistrationRequestDto registrationRequestDto){
        User user = new User();
        user.setUsername(registrationRequestDto.getUsername());
        user.setEmail(registrationRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequestDto.getPassword()));

        User saveUser = userRepository.save(user);

        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setId(saveUser.getId());
        authResponseDto.setUsername(saveUser.getUsername());
        authResponseDto.setEmail(saveUser.getEmail());
        authResponseDto.setSuccessMsg("Registration Successfully");

        return authResponseDto;
    }

    public AuthResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthResponseDto authResponseDto = new AuthResponseDto();
        User loginUser = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        authResponseDto.setId(loginUser.getId());
        authResponseDto.setUsername(loginUser.getUsername());
        authResponseDto.setEmail(loginUser.getEmail());
        authResponseDto.setSuccessMsg("You are LogIn");
        return authResponseDto;
    }

}
