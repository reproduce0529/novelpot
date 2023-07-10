package com.project.novelpot.service;

import com.project.novelpot.dto.RegisterDto;
import com.project.novelpot.entity.member.Member;
import com.project.novelpot.entity.member.Role;
import com.project.novelpot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDto dto) {
        memberRepository.save(
                Member.builder()
                        .nickname(dto.getNickname())
                        .username(dto.getUsername())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .role(Role.USER.getKey())
                        .build()
        );
    }

}
