package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rekrutacja.zad3.dto.DietDto;
import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.service.DietService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DietController
{
    private final DietService dietService;

    @GetMapping("/diets")
    public List<Diet> findAllDiets()
    {
        return dietService.findAll();
    }

    @PostMapping("/diets")
    public Diet saveDiet(@RequestBody DietDto dietDto)
    {
        return dietService.save(dietDto);
    }

    @DeleteMapping("/diets/{dietId}")
    public ResponseEntity deleteDiet(@PathVariable Integer dietId)
    {
        boolean result = dietService.delete(dietId);
        if(result)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/diets/{dietId}")
    public ResponseEntity updateDiet(@PathVariable Integer dietId, @RequestBody DietDto dietDto)
    {
        return dietService
                .update(dietId, dietDto)
                .map(diet -> new ResponseEntity(diet, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
