package com.example.rp1.controller;

import javax.websocket.server.PathParam;

import com.example.rp1.domain.departments.CreateDepartment;
import com.example.rp1.domain.departments.Departments;
import com.example.rp1.domain.departments.DepartmentsService;
import com.example.rp1.domain.users.AppUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @GetMapping("/department/create")
    public String createDepartment(Model model) {
        model.addAttribute("form", new CreateDepartment());
        return "departments/create";
    }

    @PostMapping("/department/create")
    public String createDepartment(@AuthenticationPrincipal AppUserDetails loginUser,
            CreateDepartment createDepartment) {
        Departments departments = departmentsService.createDepartment(createDepartment.getCode(),
                createDepartment.getName(), loginUser.getTenantId());
        return "redirect:/home";

    }

    @GetMapping("/department/update/{id}")
    public String updateDepartment(@AuthenticationPrincipal AppUserDetails loginUser,
            @PathVariable("id") Integer departmentId) {
        return "redirect:/home";
    }

}
