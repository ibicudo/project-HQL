package com.example.projectHQL.projectHQL.DTO;

public class UserPasswordDTO {
    private Long id;
    private String password ;

    public UserPasswordDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
