package rekrutacja.zad3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rekrutacja.zad3.dto.DietCaloriesDto;
import rekrutacja.zad3.entity.DietCalories;
import rekrutacja.zad3.repository.DietCaloriesRepository;
import rekrutacja.zad3.repository.DietOptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DietCaloriesService
{
    private final DietCaloriesRepository dietCaloriesRepository;
    private final DietOptionRepository dietOptionRepository;

    public List<DietCalories> findAll(Integer dietOptionId)
    {
        return dietCaloriesRepository.findByDietOption_DietOptionId(dietOptionId);
    }

    public Optional<DietCalories> save(Integer dietOptionId, DietCaloriesDto dietCaloriesDto)
    {
        return dietOptionRepository
                .findById(dietOptionId)
                .map(dietCaloriesDto::toEntityWith)
                .map(dietCaloriesRepository::save);
    }

    public void delete(Integer id)
    {
        dietCaloriesRepository.deleteById(id);
    }

    @Transactional
    public Optional<DietCalories> update(Integer id, DietCaloriesDto dietCaloriesDto)
    {
        return dietCaloriesRepository
                .findById(id)
                .map(dietCalories -> updateDietCalories(dietCalories, dietCaloriesDto));
    }

    private DietCalories updateDietCalories(DietCalories dietCalories, DietCaloriesDto dietCaloriesDto)
    {
        dietCalories.setCalories(dietCaloriesDto.getCalories());
        return dietCalories;
    }
}
