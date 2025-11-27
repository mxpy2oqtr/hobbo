package com.healthtracker.service.nutrition;

import com.healthtracker.entity.nutrition.Nutrition;
import com.healthtracker.repository.nutrition.NutritionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionServiceImpl implements NutritionService {

    private final NutritionRepository nutritionRepository;

    public NutritionServiceImpl(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    @Override
    public List<Nutrition> findAll() {
        return nutritionRepository.findAll();
    }

    @Override
    public Nutrition findById(Long id) {
        return nutritionRepository.findById(id)
                .orElseThrow(() -> new com.healthtracker.exception.ResourceNotFoundException("Nutrition not found with id: " + id));
    }

    @Override
    public Nutrition save(Nutrition entity) {
        return nutritionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        nutritionRepository.deleteById(id);
    }
}
