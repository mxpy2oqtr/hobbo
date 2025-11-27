package com.healthtracker.repository.nutrition;

import com.healthtracker.entity.nutrition.Nutrition;
import com.healthtracker.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends BaseRepository<Nutrition> {
}
