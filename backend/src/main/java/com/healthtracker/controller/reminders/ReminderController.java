package com.healthtracker.controller.reminders;

import com.healthtracker.dto.reminders.ReminderDto;
import com.healthtracker.entity.reminders.Reminder;
import com.healthtracker.mapper.reminders.ReminderMapper;
import com.healthtracker.service.reminders.ReminderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;
    private final ReminderMapper reminderMapper;

    public ReminderController(ReminderService reminderService, ReminderMapper reminderMapper) {
        this.reminderService = reminderService;
        this.reminderMapper = reminderMapper;
    }

    @GetMapping
    public ResponseEntity<List<ReminderDto>> getAllReminders() {
        List<ReminderDto> reminders = reminderService.findAll().stream()
                .map(reminderMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(reminders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReminderDto> getReminderById(@PathVariable Long id) {
        Reminder reminder = reminderService.findById(id);
        return new ResponseEntity<>(reminderMapper.toDto(reminder), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReminderDto> createReminder(@RequestBody ReminderDto reminderDto) {
        Reminder reminder = reminderMapper.toEntity(reminderDto);
        Reminder createdReminder = reminderService.save(reminder);
        return new ResponseEntity<>(reminderMapper.toDto(createdReminder), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
