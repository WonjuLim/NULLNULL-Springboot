package com.teamproject.festival.user.service;

import com.teamproject.festival.user.dto.UserDto;
import com.teamproject.festival.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public int insertUser(UserDto userDto){

        this.overlapId(userDto.getUserId());
        this.overlapEmail(userDto.getUserEmail());

        // 비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDto.getUserPw());

        userDto.setUserPw(encodedPassword);

        return userMapper.insertUser(userDto);
    }

    public void overlapId(String id){
        UserDto findId = userMapper.overlapId(id);

        if(findId != null){
            // IllegalStateException : 대상 객체의 상태가 호출된 메서드를 수행하기에
            // 적절하지 않을 때 발생시키는 예외
            throw new IllegalStateException("중복된 아이디입니다.");
        }
    }

    public void overlapEmail(String email){
        UserDto findEmail = userMapper.overlapEmail(email);

        if(findEmail != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }

    public Long findUserId(String id){
        return userMapper.findUserId(id);
    }


}
