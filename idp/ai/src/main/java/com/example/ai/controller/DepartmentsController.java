package com.example.ai.controller;

import com.example.ai.domain.departments.CreateDepartment;
import com.example.ai.domain.departments.Departments;
import com.example.ai.domain.departments.DepartmentsService;
import com.example.ai.domain.departments.UpdateDepartmentForm;
import com.example.ai.domain.users.AppUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
            @PathVariable("id") Long departmentId, Model model) {
        Departments departments = departmentsService.getDepartments(departmentId, loginUser.getTenantId());

        UpdateDepartmentForm form = new UpdateDepartmentForm();
        form.setId(departments.getId());
        form.setCode(departments.getCode());
        form.setName(departments.getName());

        model.addAttribute("form", form);
        return "departments/update";
    }

    @PostMapping("/department/update")
    public String updateDepartment(@AuthenticationPrincipal AppUserDetails loginUser,
            UpdateDepartmentForm updateDepartmentForm) {
        departmentsService.updateDepartments(updateDepartmentForm.getId(), updateDepartmentForm.getCode(),
                updateDepartmentForm.getName(), loginUser.getTenantId());
        return "redirect:/home";
    }

    @GetMapping("/department/delete/{id}")
    public String deleteDepartment(@AuthenticationPrincipal AppUserDetails loginUser,
            @PathVariable("id") Long departmentId) {
        departmentsService.deleteDepartments(departmentId, loginUser.getTenantId());
        return "redirect:/home";
    }

}
