package ru.pre.project.JM.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id = 0l;

    private String role;

    @ManyToMany (mappedBy = "roles")
    private Set<User> users;

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
