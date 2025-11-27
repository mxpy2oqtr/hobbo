package com.healthtracker.entity.reminders;

import com.healthtracker.entity.BaseEntity;
import com.healthtracker.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reminders")
public class Reminder extends BaseEntity {

    private String title;
    private String description;
    private LocalDateTime reminderTime;
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
