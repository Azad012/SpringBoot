package com.azad.hello.service;

import com.azad.hello.dto.AuthResponseDto;
import com.azad.hello.dto.LoginRequestDto;
import com.azad.hello.dto.RegistrationRequestDto;
import com.azad.hello.entity.User;
import com.azad.hello.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDto register(RegistrationRequestDto registrationRequestDto){

        User user = new User();
        user.setUsername(registrationRequestDto.getUsername());
        user.setEmail(registrationRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequestDto.getPassword()));


        User saveUser = userRepository.save(user);

        AuthResponseDto authResponseDto = new  AuthResponseDto();

        authResponseDto.setId(saveUser.getId());
        authResponseDto.setUsername(saveUser.getUsername());
        authResponseDto.setEmail(saveUser.getEmail());
        authResponseDto.setSuccessMess("Registration Successful");


        return authResponseDto;
    }

    public AuthResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword());

        authenticationManager.authenticate(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<User> user1 = userRepository.findByUsername(loginRequestDto.getUsername());



        AuthResponseDto authResponseDto = new AuthResponseDto();

        authResponseDto.setId(user1.get().getId());
        authResponseDto.setUsername(user1.get().getUsername());
        authResponseDto.setEmail(user1.get().getEmail());
        authResponseDto.setSuccessMess("You are Loged In");
        return authResponseDto;
    }
}
