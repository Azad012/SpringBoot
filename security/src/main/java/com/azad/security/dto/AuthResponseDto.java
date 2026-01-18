package com.azad.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponseDto {
    private Long id;
    private String username;
    private String email;
    private String successMsg;


}
