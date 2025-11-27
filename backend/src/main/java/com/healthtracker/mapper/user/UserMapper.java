package com.healthtracker.mapper.user;

import com.healthtracker.dto.user.UserDto;
import com.healthtracker.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
