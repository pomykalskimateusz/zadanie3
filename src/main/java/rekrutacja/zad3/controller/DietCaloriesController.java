package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rekrutacja.zad3.dto.DietCaloriesDto;
import rekrutacja.zad3.entity.DietCalories;
import rekrutacja.zad3.service.DietCaloriesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietCaloriesController
{
    private final DietCaloriesService dietCaloriesService;

    @GetMapping("/diets/options/{dietOptionId}/calories")
    public List<DietCalories> findDietOptionCalories(@PathVariable Integer dietOptionId)
    {
        return dietCaloriesService.findAll(dietOptionId);
    }

    @PostMapping("/diets/options/{dietOptionId}/calories")
    public ResponseEntity saveDietOptionCalories(@PathVariable Integer dietOptionId, @RequestBody DietCaloriesDto dietCaloriesDto)
    {
        return dietCaloriesService
                .save(dietOptionId, dietCaloriesDto)
                .map(dietCalories -> new ResponseEntity(dietCalories, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/diets/options/calories/{dietCaloriesId}")
    public ResponseEntity deleteDietCalories(@PathVariable Integer dietCaloriesId)
    {
        boolean result = dietCaloriesService.delete(dietCaloriesId);
        if(result)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/diets/options/calories/{dietCaloriesId}")
    public ResponseEntity updateCalories(@PathVariable Integer dietCaloriesId, @RequestBody DietCaloriesDto dietCaloriesDto)
    {
        return dietCaloriesService
                .update(dietCaloriesId, dietCaloriesDto)
                .map(dietCalories -> new ResponseEntity(dietCalories, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
