package com.example.rp1.domain.users;

public class UpdateUserForm {

    private Integer id;

    private String code;

    private String email;

    private String firstName;

    private String lastName;

    private String firstNameKana;

    private String lastNameKana;

    private Integer dno1;

    private Integer dno2;

    private Integer dno3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getDno1() {
        return dno1;
    }

    public void setDno1(Integer dno1) {
        this.dno1 = dno1;
    }

    public Integer getDno2() {
        return dno2;
    }

    public void setDno2(Integer dno2) {
        this.dno2 = dno2;
    }

    public Integer getDno3() {
        return dno3;
    }

    public void setDno3(Integer dno3) {
        this.dno3 = dno3;
    }

}
