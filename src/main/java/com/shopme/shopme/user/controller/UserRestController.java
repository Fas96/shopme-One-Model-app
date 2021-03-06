package com.shopme.shopme.user.controller;

import com.shopme.shopme.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService service;
    @PostMapping("/users/check_email")
    public String checkDuplicateEmail(@Param("email") String email,@Param("id") Integer id){

        return service.isEmailUnique(id,email)?"Ok":"Duplicate";
    }
}
