package com.indievivo.indievivoapi.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(name = "uk_role_name", columnNames = "name")})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50, updatable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}