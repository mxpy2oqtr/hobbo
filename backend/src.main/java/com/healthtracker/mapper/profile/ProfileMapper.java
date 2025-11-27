package com.healthtracker.mapper.profile;

import com.healthtracker.dto.profile.ProfileDto;
import com.healthtracker.entity.profile.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(source = "user.id", target = "userId")
    ProfileDto toDto(Profile profile);

    @Mapping(source = "userId", target = "user.id")
    Profile toEntity(ProfileDto profileDto);
}
