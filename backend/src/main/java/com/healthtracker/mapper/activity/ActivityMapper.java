package com.healthtracker.mapper.activity;

import com.healthtracker.dto.activity.ActivityDto;
import com.healthtracker.entity.activity.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    @Mapping(source = "user.id", target = "userId")
    ActivityDto toDto(Activity activity);

    @Mapping(source = "userId", target = "user.id")
    Activity toEntity(ActivityDto activityDto);
}
