package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rekrutacja.zad3.dto.DietDto;
import rekrutacja.zad3.dto.DietOptionDto;
import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.entity.DietOption;
import rekrutacja.zad3.service.DietOptionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DietOptionController
{
    private final DietOptionService dietOptionService;

    @GetMapping("/diets/{dietId}/options")
    public List<DietOption> findDietOptions(@PathVariable Integer dietId)
    {
        return dietOptionService.findAll(dietId);
    }

    @PostMapping("/diets/{dietId}/options")
    public Optional<DietOption> saveDietOption(@PathVariable Integer dietId, @RequestBody DietOptionDto dietOptionDto)
    {
        return dietOptionService.save(dietId, dietOptionDto);
    }

    @PutMapping("/options/{dietOptionId}")
    public Optional<DietOption> updateDietOption(@PathVariable Integer dietOptionId, @RequestBody DietOptionDto dietOptionDto)
    {
        return dietOptionService.update(dietOptionId, dietOptionDto);
    }
}
