package org.example.test2805.controllers;

import org.example.test2805.entities.Role;
import org.example.test2805.entities.User;
import org.example.test2805.requestEntities.RequestCreateUser;
import org.example.test2805.requestEntities.RequestUpdateUser;
import org.example.test2805.services.RoleService;
import org.example.test2805.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/index";
    }

    @GetMapping("/edit/{id}")
    public String showUserForm(@PathVariable String id, Model model) {
        List<Role> roles = roleService.findAll();
        User user = userService.findById(id);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/saveedit")
    public String saveEditUser(@ModelAttribute RequestUpdateUser requestUpdateUser) {
        User user = userService.findById(requestUpdateUser.getId());
        requestUpdateUser.setRole(user.getRole());
        userService.update(requestUpdateUser.getId(), requestUpdateUser);
        return "redirect:/users";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        User user = new User();
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "user/create";
    }

    @PostMapping("/create")
    public String saveCreateUser(@ModelAttribute RequestCreateUser requestCreateUser) {
        userService.addNewUser(requestCreateUser);
        return "redirect:/users";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable String id, Model model) {
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        return "user/delete";
//    }

//    @PostMapping("/savedelete")
//    public String deleteUser(@PathVariable String id, Model model) {
//        User user = userService.findById(id);
//        user.setDeleted(!user.isDeleted());
//        userService.delete(id);
//        return "redirect:/users";
//    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        if ( userService.findById(id) != null){
            userService.delete(id);
        }
        return "redirect:/users";
    }
}
