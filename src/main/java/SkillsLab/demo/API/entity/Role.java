package SkillsLab.demo.API.entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
//GrantedAuthority from security package
public class Role implements GrantedAuthority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
       return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    


}
