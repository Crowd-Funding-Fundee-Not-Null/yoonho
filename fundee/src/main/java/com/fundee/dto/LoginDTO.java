package com.fundee.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String id;
    private String password;
    private String passwordCheck; // 검증용(DB컬럼X)
    private String nickname;
    private String join_date;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Integer role; 
}
