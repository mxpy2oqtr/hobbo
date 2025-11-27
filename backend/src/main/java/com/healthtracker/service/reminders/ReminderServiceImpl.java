package com.healthtracker.service.reminders;

import com.healthtracker.entity.reminders.Reminder;
import com.healthtracker.repository.reminders.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public List<Reminder> findAll() {
        return reminderRepository.findAll();
    }

    @Override
    public Reminder findById(Long id) {
        return reminderRepository.findById(id)
                .orElseThrow(() -> new com.healthtracker.exception.ResourceNotFoundException("Reminder not found with id: " + id));
    }

    @Override
    public Reminder save(Reminder entity) {
        return reminderRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        reminderRepository.deleteById(id);
    }
}
