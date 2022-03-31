package com.example.rp2.domain.users;

public class UpdateUserForm {

    private Long id;

    private String code;

    private String email;

    private String firstName;

    private String lastName;

    private String firstNameKana;

    private String lastNameKana;

    private Long dno1;

    private Long dno2;

    private Long dno3;

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
