package com.project.novelpot.controller;

import com.project.novelpot.dto.BoardWriteDto;
import com.project.novelpot.service.BoardService;
import com.project.novelpot.service.UserService;
import com.project.novelpot.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(RegisterDto dto) {
        userService.register(dto);
        return "login";
    }

}
