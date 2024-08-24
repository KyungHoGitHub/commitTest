package com.example.springbootdeveloper.service;

import com.example.springbootdeveloper.domain.User;
import com.example.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService  implements UserDetailsService {

    private final UserRepository userRepository;

    // 사용자 이름(email)으로 사용자 정보를 가져오는 메서드
    public User loadUserByUsername(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException((email)));
    }
}
