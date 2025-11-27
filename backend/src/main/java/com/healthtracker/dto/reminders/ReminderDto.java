package com.healthtracker.dto.reminders;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReminderDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime reminderTime;
    private boolean enabled;
    private Long userId;
}
