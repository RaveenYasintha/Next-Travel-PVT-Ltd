package com.next.user_service.service.Impl;

import com.next.user_service.dto.LoginDto;
import com.next.user_service.entity.User;
import com.next.user_service.repository.UserRepository;
import com.next.user_service.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public User updateUser(User user) {
//        return null;
//    }

    @Override
    public LoginDto addUser(LoginDto loginDto) {
        User user = this.dtoToEntity(loginDto);
        User save = this.userRepository.save(user);
        return new LoginDto(save);
    }

//    @Override
//    public User updateUser(User user) {
//        if (!userRepository.existsById(user.getId())) {
//            throw new RuntimeException("User Not Found");
//        }
//        return userRepository.save(user);
//    }user

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(id);
    }
    @Override
    public User checkLogin(String userName, String password) {
        if (!userRepository.existsByUserNameAndPassword(userName,password)) {
            throw new RuntimeException("User Not Found");
        }
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Optional<User> searchUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<LoginDto> getAllUsers() {
        List<User> all = this.userRepository.findAll();
        List<LoginDto> allUserDtos = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            LoginDto loginDto = new LoginDto(all.get(i));
            allUserDtos.add(loginDto);
        }
        return allUserDtos;

    }

    @Override
    public LoginDto updateUser(Long userId, LoginDto updateLoginDto) {
        Optional<User> byId = userRepository.findById(userId);
        updateLoginDto.setId(userId);
        User user = this.dtoToEntity(updateLoginDto);

        if (byId.isPresent()){
            User save = userRepository.save(user);
            return new LoginDto(save);
        }else {
            return null;
        }
    }

//    @Override
//    public List<User> fetchAllUsers() {
//        return userRepository.findAll();
//    }

    private User dtoToEntity(LoginDto loginDto) {
        User user  = new User();
        BeanUtils.copyProperties(loginDto, user);
        return user;
    }

}
