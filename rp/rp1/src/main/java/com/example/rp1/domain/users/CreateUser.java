package com.example.rp1.domain.users;

import lombok.Data;

@Data
public class CreateUser {
    public String code;
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String firstNameKana;
    public String lastNameKana;
    public Long dno1;
    public Long dno2;
    public Long dno3;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Long getDno1() {
        return dno1;
    }

    public void setDno1(Long dno1) {
        this.dno1 = dno1;
    }

    public Long getDno2() {
        return dno2;
    }

    public void setDno2(Long dno2) {
        this.dno2 = dno2;
    }

    public Long getDno3() {
        return dno3;
    }

    public void setDno3(Long dno3) {
        this.dno3 = dno3;
    }
}
