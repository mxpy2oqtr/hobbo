package com.healthtracker.service.activity;

import com.healthtracker.entity.activity.Activity;
import com.healthtracker.repository.activity.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new com.healthtracker.exception.ResourceNotFoundException("Activity not found with id: " + id));
    }

    @Override
    public Activity save(Activity entity) {
        return activityRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
