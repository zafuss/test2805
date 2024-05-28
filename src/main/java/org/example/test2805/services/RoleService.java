package org.example.test2805.services;

import jakarta.persistence.EntityNotFoundException;
import org.example.test2805.entities.Role;
import org.example.test2805.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    public Role findById(String id) {
        return roleRepository.findById(id).orElseThrow(
        ()->  new EntityNotFoundException("Role Not Found"));
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role) {
        return roleRepository.save(role);
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }

}
