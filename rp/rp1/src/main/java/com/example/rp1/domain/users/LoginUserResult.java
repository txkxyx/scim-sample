package com.example.rp1.domain.users;

public class LoginUserResult {

    private Long id;

    private String code;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String firstNameKana;

    private String lastNameKana;

    private String departmentName1;

    private String departmentName2;

    private String departmentName3;

    private String tenantName;

    private Long tenantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getDepartmentName1() {
        return departmentName1;
    }

    public void setDepartmentName1(String departmentName1) {
        this.departmentName1 = departmentName1;
    }

    public String getDepartmentName2() {
        return departmentName2;
    }

    public void setDepartmentName2(String departmentName2) {
        this.departmentName2 = departmentName2;
    }

    public String getDepartmentName3() {
        return departmentName3;
    }

    public void setDepartmentName3(String departmentName3) {
        this.departmentName3 = departmentName3;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
