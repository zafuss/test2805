package org.example.test2805.requestEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.test2805.entities.Role;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isDeleted;
    private Role role;
}

