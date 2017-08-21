
package com.example.entity;

import java.util.List;

public class UserRoles {
    List<String> roles;

    
    public UserRoles(List<String> roles) {
        this.roles = roles;
    }


    public List<String> getRoles() {
    
        return roles;
    }

    @Override
    public String toString() {
        return String.format("UserRoles [roles=%s]", roles);
    }

}
