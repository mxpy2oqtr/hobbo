package com.healthtracker.entity.nutrition;

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
@Table(name = "nutrition")
public class Nutrition extends BaseEntity {

    private String foodItem;
    private Integer calories;
    private Integer protein; // in grams
    private Integer carbohydrates; // in grams
    private Integer fat; // in grams
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
