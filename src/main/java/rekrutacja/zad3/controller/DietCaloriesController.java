package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rekrutacja.zad3.dto.DietCaloriesDto;
import rekrutacja.zad3.dto.DietOptionDto;
import rekrutacja.zad3.entity.DietCalories;
import rekrutacja.zad3.entity.DietOption;
import rekrutacja.zad3.service.DietCaloriesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DietCaloriesController
{
    private final DietCaloriesService dietCaloriesService;

    @GetMapping("/options/{dietOptionId}/calories")
    public List<DietCalories> findDietOptionCalories(@PathVariable Integer dietOptionId)
    {
        return dietCaloriesService.findAll(dietOptionId);
    }

    @PostMapping("/options/{dietOptionId}/calories")
    public Optional<DietCalories> saveDietOptionCalories(@PathVariable Integer dietOptionId, @RequestBody DietCaloriesDto dietCaloriesDto)
    {
        return dietCaloriesService.save(dietOptionId, dietCaloriesDto);
    }

    @PutMapping("/calories/{dietCaloriesId}")
    public Optional<DietCalories> updateCalories(@PathVariable Integer dietCaloriesId, @RequestBody DietCaloriesDto dietCaloriesDto)
    {
        return dietCaloriesService.update(dietCaloriesId, dietCaloriesDto);
    }
}
