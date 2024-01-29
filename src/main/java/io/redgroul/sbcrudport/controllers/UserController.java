package io.redgroul.sbcrudport.controllers;

import io.redgroul.sbcrudport.model.User;
import io.redgroul.sbcrudport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/addUser")
    public String printAddPage(@ModelAttribute("user") User user) {
        return "add";
    }
    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/removeUser/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping(value = "/user/{id}")
    public String editUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return  "edit";
    }

    @PostMapping(value = "/user/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }



}
