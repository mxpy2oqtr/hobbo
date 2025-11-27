package com.healthtracker.dto.activity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ActivityDto {

    private Long id;
    private String type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDate date;
    private Long userId;
}
