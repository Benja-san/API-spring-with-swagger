package SkillsLab.demo.API.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import SkillsLab.demo.API.entity.User;

import SkillsLab.demo.API.entity.Role;

@Component
public class UserGeneratorRepository implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserGeneratorRepository(
        UserRepository userRepository, 
        RoleRepository roleRepository,
        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        userRole = roleRepository.save(userRole);
        adminRole = roleRepository.save(adminRole);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(userRole);
        adminRoles.add(adminRole);

        User tyler = new User("tyler Durden", passwordEncoder.encode("password"), "tyler@gmail.com", userRoles);
        User Remy = new User("remy", passwordEncoder.encode("password"), "remy@gmail.com", adminRoles);

        userRepository.save(tyler);
        userRepository.save(Remy);
    }
    
}
