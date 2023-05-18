package com.rentacar.entity;

import com.rentacar.exeption.ResourceNotFountException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
public enum UserRole {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(r -> r.value.equals(userRole))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Role %s not founf",userRole)));
    }

    public String getValue() {
        return value;
    }
}

