package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.dto.AddUserRequest;
import com.example.springbootdeveloper.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final Userservice userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request);
        return "redirect:/login";
    }
}
