package org.example.test2805.controllers;

import org.example.test2805.entities.Role;
import org.example.test2805.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("role", new Role());
        return "role/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }
    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable String id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "role/edit";
    }

    @PostMapping("/saveedit")
    public String saveEditRole(@ModelAttribute("role") Role role) {
        roleService.update(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "role/delete";
    }
    @PostMapping("/saveDelete")
    public String deleteRole(@ModelAttribute("role") Role role) {
        roleService.delete(role.getRole_id());
        return "redirect:/roles";
    }
}
