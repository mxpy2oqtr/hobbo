package com.healthtracker.controller.activity;

import com.healthtracker.dto.activity.ActivityDto;
import com.healthtracker.entity.activity.Activity;
import com.healthtracker.mapper.activity.ActivityMapper;
import com.healthtracker.service.activity.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    public ActivityController(ActivityService activityService, ActivityMapper activityMapper) {
        this.activityService = activityService;
        this.activityMapper = activityMapper;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        List<ActivityDto> activities = activityService.findAll().stream()
                .map(activityMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        return new ResponseEntity<>(activityMapper.toDto(activity), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(@RequestBody ActivityDto activityDto) {
        Activity activity = activityMapper.toEntity(activityDto);
        Activity createdActivity = activityService.save(activity);
        return new ResponseEntity<>(activityMapper.toDto(createdActivity), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
