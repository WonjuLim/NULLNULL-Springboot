package com.teamproject.festival.user.dto;

import com.teamproject.festival.user.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userUSEYN;
    private String userGender;
    private String userAddress;
    private Role userRole;

}
