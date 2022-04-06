package com.example.ai.controller;

import java.util.List;

import com.example.ai.domain.departments.Departments;
import com.example.ai.domain.departments.DepartmentsService;
import com.example.ai.domain.users.AppUserDetails;
import com.example.ai.domain.users.CreateUser;
import com.example.ai.domain.users.LoginUserDto;
import com.example.ai.domain.users.UpdateUserForm;
import com.example.ai.domain.users.Users;
import com.example.ai.domain.users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private DepartmentsService departmentsService;

    @GetMapping("/home")
    public String getHome(@AuthenticationPrincipal AppUserDetails loginUser, Model model) {
        LoginUserDto loginUserDto = usersService.getLoginUser(loginUser.getId(), loginUser.getTenantId());
        List<Users> users = usersService.getAllUsers(loginUser.getTenantId());
        List<Departments> departments = departmentsService.getAllDepartments(loginUser.getTenantId());

        model.addAttribute("loginUser", loginUserDto);
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

    @GetMapping("/user/update/{id}")
    public String updateUser(@AuthenticationPrincipal AppUserDetails loginUser, Model model,
            @PathVariable("id") Long userId) {
        Users user = usersService.getUser(userId, loginUser.getTenantId());
        UpdateUserForm form = new UpdateUserForm();
        form.setId(user.getId());
        form.setCode(user.getCode());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setFirstNameKana(user.getFirstNameKana());
        form.setLastNameKana(user.getLastNameKana());
        form.setDno1(user.getDno1());
        form.setDno2(user.getDno2());
        form.setDno3(user.getDno3());

        List<Departments> departments = departmentsService.getAllDepartments(loginUser.getTenantId());

        model.addAttribute("form", form);
        model.addAttribute("departments", departments);
        return "users/update";
    }

    @PostMapping("/user/update")
    public String updateUser(@AuthenticationPrincipal AppUserDetails loginuUser, UpdateUserForm updateUserForm) {
        usersService.updateUsers(updateUserForm.getId(), updateUserForm.getCode(), updateUserForm.getEmail(),
                updateUserForm.getFirstName(), updateUserForm.getLastName(), updateUserForm.getFirstNameKana(),
                updateUserForm.getLastNameKana(), updateUserForm.getDno1(), updateUserForm.getDno2(),
                updateUserForm.getDno3(), loginuUser.getTenantId());
        return "redirect:/home";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@AuthenticationPrincipal AppUserDetails loginUser, @PathVariable("id") Long id) {
        usersService.deleteUsers(id, loginUser.getTenantId());
        return "redirect:/home";
    }
}
