package com.productk12Api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private int [] rid;
}
