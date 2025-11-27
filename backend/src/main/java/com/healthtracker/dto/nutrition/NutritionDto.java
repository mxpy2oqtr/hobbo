package com.healthtracker.dto.nutrition;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NutritionDto {

    private Long id;
    private String foodItem;
    private Integer calories;
    private Integer protein;
    private Integer carbohydrates;
    private Integer fat;
    private LocalDate date;
    private Long userId;
}
