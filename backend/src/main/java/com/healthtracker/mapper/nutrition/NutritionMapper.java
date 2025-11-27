package com.healthtracker.mapper.nutrition;

import com.healthtracker.dto.nutrition.NutritionDto;
import com.healthtracker.entity.nutrition.Nutrition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NutritionMapper {

    @Mapping(source = "user.id", target = "userId")
    NutritionDto toDto(Nutrition nutrition);

    @Mapping(source = "userId", target = "user.id")
    Nutrition toEntity(NutritionDto nutritionDto);
}
