package com.example.discgolf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Size(min = 1, max = 100)
        private String name;

        @NotNull
        private String username;


        @NotNull
        @Email
        @Size(min = 1, max = 100)
        private String email;

        @NotNull
        @Size(min = 8)
        private String password;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )

        private Set<Role> roles;

    // we want to create getters and setters for the user model
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }
    public String getUsername() {
        return username;
    };

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    // we want to create a toString method for the user model to return the name, email, and password
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email +'\'' +
                ", password='" + password + '\'' +
                '}';
    }


    // we want to create a method to check if the user's email and password match the database
    public boolean checkUser(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    // we want to create a method to check if the user's email matches the database
    public boolean checkEmail(String email) {
        if (this.email.equals(email)) {
            return true;
        } else {
            return false;
        }
    }


    // we want to create a method to check if the user's password matches the database
    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    // we want to create a method to check if the user's name matches the database
    public boolean checkName(String name) {
        if (this.name.equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    // we want to set user roles and permissions
    public String getRole() {
        return "USER";
    }

    public String getPermission() {
        return "READ";
    }

        public void setId(Long id) {
            this.id = id;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }
    }
