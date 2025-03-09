package com.neobankx.account_service.client;

import com.neobankx.account_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    UserDto getUserById(@PathVariable Long id);
}
