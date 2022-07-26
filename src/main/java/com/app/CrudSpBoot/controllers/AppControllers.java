package com.app.CrudSpBoot.controllers;


import com.app.CrudSpBoot.models.User;
import com.app.CrudSpBoot.service.UserServicelmpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AppControllers {

    private final UserServicelmpl userService;

    public AppControllers(UserServicelmpl userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String indexAllUsers(Model model) {
        model.addAttribute( "users", userService.getAllUsers());
        return "users/index";
    }


    @GetMapping("/{id}")
    public String showID(@PathVariable("id") int id, Model model ) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/showID";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping()
    public String createUsers(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
