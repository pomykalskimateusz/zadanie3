package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rekrutacja.zad3.dto.DietDto;
import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.service.DietService;

import java.util.List;
import java.util.Optional;

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
    public void deleteDiet(@PathVariable Integer dietId)
    {
        dietService.delete(dietId);
    }

    @PutMapping("/diets/{dietId}")
    public Optional<Diet> updateDiet(@PathVariable Integer dietId, @RequestBody DietDto dietDto)
    {
        return dietService.update(dietId, dietDto);
    }
}
