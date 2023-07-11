package SkillsLab.demo.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SkillsLab.demo.API.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
