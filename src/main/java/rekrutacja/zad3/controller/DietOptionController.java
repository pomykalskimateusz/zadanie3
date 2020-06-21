package rekrutacja.zad3.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rekrutacja.zad3.dto.DietOptionDto;
import rekrutacja.zad3.entity.DietOption;
import rekrutacja.zad3.service.DietOptionService;

import java.util.List;

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
    public ResponseEntity saveDietOption(@PathVariable Integer dietId, @RequestBody DietOptionDto dietOptionDto)
    {
        return dietOptionService
                .save(dietId, dietOptionDto)
                .map(dietOption -> new ResponseEntity(dietOption, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/options/{dietOptionId}")
    public ResponseEntity deleteDietOption(@PathVariable Integer dietOptionId)
    {
        boolean result = dietOptionService.delete(dietOptionId);
        if(result)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/options/{dietOptionId}")
    public ResponseEntity updateDietOption(@PathVariable Integer dietOptionId, @RequestBody DietOptionDto dietOptionDto)
    {
        return dietOptionService
                .update(dietOptionId, dietOptionDto)
                .map(dietOption -> new ResponseEntity(dietOption, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
