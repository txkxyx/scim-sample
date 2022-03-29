package com.example.rp1.controller;

import java.util.List;

import com.example.rp1.domain.departments.Departments;
import com.example.rp1.domain.departments.DepartmentsRepository;
import com.example.rp1.domain.departments.DepartmentsService;
import com.example.rp1.domain.users.AppUserDetails;
import com.example.rp1.domain.users.CreateUser;
import com.example.rp1.domain.users.Users;
import com.example.rp1.domain.users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private DepartmentsService departmentsService;

    @GetMapping("/home")
    public String getHome(@AuthenticationPrincipal AppUserDetails loginUser, Model model) {
        List<Users> users = usersService.getAllUsers(loginUser.getTenantId());
        List<Departments> departments = departmentsService.getAllDepartments(loginUser.getTenantId());
        model.addAttribute("users", users);
        model.addAttribute("departments", departments);
        return "home";
    }

    @GetMapping("/user/create")
    public String createUser(@AuthenticationPrincipal AppUserDetails loginUser, Model model) {
        List<Departments> departments = departmentsService.getAllDepartments(loginUser.getTenantId());
        model.addAttribute("form", new CreateUser());
        model.addAttribute("departments", departments);
        return "/users/create";
    }

    @PostMapping("/user/create")
    public String createuser(@AuthenticationPrincipal AppUserDetails loginUser, CreateUser createUser) {
        Users user = usersService.createUser(createUser.getCode(), createUser.getEmail(), createUser.getFirstName(),
                createUser.getLastName(), createUser.getFirstNameKana(), createUser.getLastNameKana(),
                createUser.getDno1(), createUser.getDno2(), createUser.getDno3(), loginUser.getTenantId());
        return "redirect:/home";
    }

}
