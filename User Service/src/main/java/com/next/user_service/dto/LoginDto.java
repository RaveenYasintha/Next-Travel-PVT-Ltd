package com.next.user_service.dto;

import com.next.user_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String nicOrPassportNum;
    private String userName;
    private String password;
    private String role;
    private String proPicUrl;

    public LoginDto(User user) {
        BeanUtils.copyProperties(user, this);
    }

}
