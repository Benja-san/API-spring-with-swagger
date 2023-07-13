package SkillsLab.demo.API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SkillsLab.demo.API.entity.User;
import SkillsLab.demo.API.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find users", description = "Find all users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/api/users/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/auth/register")
    public User register(String username, String password, String email) {
        return userService.register(username, password, email);
    }

    @PostMapping("/auth/login")
    public String login(String email, String password) {
        return userService.login(email, password);
    }

}
