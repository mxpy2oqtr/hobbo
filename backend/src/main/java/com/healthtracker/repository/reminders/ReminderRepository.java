package com.healthtracker.repository.reminders;

import com.healthtracker.entity.reminders.Reminder;
import com.healthtracker.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends BaseRepository<Reminder> {
}
