package com.healthtracker.entity.profile;

import com.healthtracker.entity.BaseEntity;
import com.healthtracker.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity {

    private LocalDate dateOfBirth;
    private String gender;
    private Double height; // in cm
    private Double weight; // in kg

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
