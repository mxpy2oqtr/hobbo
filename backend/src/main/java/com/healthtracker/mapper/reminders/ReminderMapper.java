package com.healthtracker.mapper.reminders;

import com.healthtracker.dto.reminders.ReminderDto;
import com.healthtracker.entity.reminders.Reminder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReminderMapper {

    @Mapping(source = "user.id", target = "userId")
    ReminderDto toDto(Reminder reminder);

    @Mapping(source = "userId", target = "user.id")
    Reminder toEntity(ReminderDto reminderDto);
}
