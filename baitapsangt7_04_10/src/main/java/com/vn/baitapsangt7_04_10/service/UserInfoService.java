package com.vn.baitapsangt7_04_10.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vn.baitapsangt7_04_10.config.UserInfoUserDetails;
import com.vn.baitapsangt7_04_10.entity.UserInfo;
import com.vn.baitapsangt7_04_10.repository.UserInfoRepository;

public class UserInfoService implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user name not found" + username));
    }

}
