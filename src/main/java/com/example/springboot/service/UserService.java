package com.example.springboot.service;

import com.example.springboot.dbo.req.UserReq;
import com.example.springboot.dbo.res.UserRes;
import com.example.springboot.entity.Users;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public List<UserRes> all(){
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserRes create(UserReq employe){
        return userMapper.toDTO(
                userRepository.save(
                        userMapper.toEntity(employe)));
    }
    public UserRes update(Long id, UserReq userReq) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(userReq.getName());
        existingUser.setPosition(userReq.getPosition());
        existingUser.setSalary(userReq.getSalary());

        return userMapper.toDTO(userRepository.save(existingUser));
    }


}
