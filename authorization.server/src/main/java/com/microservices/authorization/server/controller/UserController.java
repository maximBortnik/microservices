package com.microservices.authorization.server.controller;

import com.microservices.authorization.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author bortnik
 */
@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
