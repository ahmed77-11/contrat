package com.medfactor.contrat.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String cin;
    private String firstName;
    private String lastName;
    private List<RoleDto> roles;


}