package com.vn.baitapsangt7_04_10.service;

import java.net.PasswordAuthentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vn.baitapsangt7_04_10.entity.UserInfo;
import com.vn.baitapsangt7_04_10.repository.UserInfoRepository;

@Service
public record UserService(UserInfoRepository userInfoRepository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "thêm thành công";
    }
}
