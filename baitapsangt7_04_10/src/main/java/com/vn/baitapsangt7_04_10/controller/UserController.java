package com.vn.baitapsangt7_04_10.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.baitapsangt7_04_10.entity.UserInfo;
import com.vn.baitapsangt7_04_10.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}
