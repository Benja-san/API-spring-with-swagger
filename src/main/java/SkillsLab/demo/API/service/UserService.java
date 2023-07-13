package SkillsLab.demo.API.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SkillsLab.demo.API.entity.Role;
import SkillsLab.demo.API.entity.User;
import SkillsLab.demo.API.repository.RoleRepository;
import SkillsLab.demo.API.repository.UserRepository;

@Service
//UserDetailsService from security package
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public UserService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        RoleRepository roleRepository,
        TokenService tokenService,
        @Lazy AuthenticationManager authenticationManager
        ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Security method to implement
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository.findByEmail(userEmail)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User register(String username, String password, String email) {
        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("ROLE_USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User(username, encodedPassword, email, roles);
        return userRepository.save(user);
    }

    public String login(String email, String password) {
        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );
        return tokenService.generateToken(authentication);
    }
    
}
