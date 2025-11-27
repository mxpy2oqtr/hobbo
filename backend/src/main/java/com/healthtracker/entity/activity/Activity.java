package com.healthtracker.entity.activity;

import com.healthtracker.entity.BaseEntity;
import com.healthtracker.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    private String type;
    private Integer duration; // in minutes
    private Integer caloriesBurned;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
