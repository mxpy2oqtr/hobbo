package com.healthtracker.controller.profile;

import com.healthtracker.dto.profile.ProfileDto;
import com.healthtracker.entity.profile.Profile;
import com.healthtracker.mapper.profile.ProfileMapper;
import com.healthtracker.service.profile.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        List<ProfileDto> profiles = profileService.findAll().stream()
                .map(profileMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.findById(id);
        return new ResponseEntity<>(profileMapper.toDto(profile), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDto) {
        Profile profile = profileMapper.toEntity(profileDto);
        Profile createdProfile = profileService.save(profile);
        return new ResponseEntity<>(profileMapper.toDto(createdProfile), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
