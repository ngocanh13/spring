package com.example.springboot.mapper;

import com.example.springboot.dbo.req.UserReq;
import com.example.springboot.dbo.res.UserRes;
import com.example.springboot.entity.Users;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserReq userReq);
    UserRes toDTO(Users users);
}
