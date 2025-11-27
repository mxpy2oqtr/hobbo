package com.healthtracker.service.profile;

import com.healthtracker.entity.profile.Profile;
import com.healthtracker.repository.profile.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new com.healthtracker.exception.ResourceNotFoundException("Profile not found with id: " + id));
    }

    @Override
    public Profile save(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
