package SkillsLab.demo.API.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SkillsLab.demo.API.entity.User;
import SkillsLab.demo.API.repository.UserRepository;

@Service
//UserDetailsService from security package
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    
}
