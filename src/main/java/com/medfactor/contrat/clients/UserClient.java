package com.medfactor.contrat.clients;

import com.medfactor.contrat.dtos.UserDto;
import com.medfactor.contrat.security.FeignConfig;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name ="factor-users" ,url="http://localhost:8082",configuration = FeignConfig.class)
public interface UserClient {
    @GetMapping("/factoring/users/api/user/{id}")
    Optional<UserDto> getUserById(@PathVariable("id") Long id);

    @GetMapping("/factoring/users/api//usersByRole/{role}")
    List<UserDto> getUsersByRole(@PathVariable("role") String role);


}
