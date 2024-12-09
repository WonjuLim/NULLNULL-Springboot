package com.teamproject.festival.user.mapper;


import com.teamproject.festival.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(UserDto userDto);

    UserDto overlapId(String id);
    UserDto overlapEmail(String email);
    UserDto loginUser(String id);
    Long findUserId(String id);

}
