package com.healthtracker.controller.nutrition;

import com.healthtracker.dto.nutrition.NutritionDto;
import com.healthtracker.entity.nutrition.Nutrition;
import com.healthtracker.mapper.nutrition.NutritionMapper;
import com.healthtracker.service.nutrition.NutritionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    private final NutritionService nutritionService;
    private final NutritionMapper nutritionMapper;

    public NutritionController(NutritionService nutritionService, NutritionMapper nutritionMapper) {
        this.nutritionService = nutritionService;
        this.nutritionMapper = nutritionMapper;
    }

    @GetMapping
    public ResponseEntity<List<NutritionDto>> getAllNutrition() {
        List<NutritionDto> nutrition = nutritionService.findAll().stream()
                .map(nutritionMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(nutrition, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionDto> getNutritionById(@PathVariable Long id) {
        Nutrition nutrition = nutritionService.findById(id);
        return new ResponseEntity<>(nutritionMapper.toDto(nutrition), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NutritionDto> createNutrition(@RequestBody NutritionDto nutritionDto) {
        Nutrition nutrition = nutritionMapper.toEntity(nutritionDto);
        Nutrition createdNutrition = nutritionService.save(nutrition);
        return new ResponseEntity<>(nutritionMapper.toDto(createdNutrition), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutrition(@PathVariable Long id) {
        nutritionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
