package com.healthtracker.dto.profile;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileDto {

    private Long id;
    private LocalDate dateOfBirth;
    private String gender;
    private Double height;
    private Double weight;
    private Long userId;
}
