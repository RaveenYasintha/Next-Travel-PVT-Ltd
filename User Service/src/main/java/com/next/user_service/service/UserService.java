package com.next.user_service.service;

import com.next.user_service.dto.LoginDto;
import com.next.user_service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    LoginDto addUser(LoginDto loginDto);

    void deleteUser(Integer id);

    void deleteUser(Long id);

    User checkLogin(String userName, String password);


    Optional<User> searchUser(Long id);

    List<LoginDto> getAllUsers();

    LoginDto updateUser(Long userId, LoginDto updateLoginDto);
}
