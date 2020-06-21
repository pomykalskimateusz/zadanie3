package rekrutacja.zad3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rekrutacja.zad3.dto.DietOptionDto;
import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.entity.DietOption;
import rekrutacja.zad3.repository.DietOptionRepository;
import rekrutacja.zad3.repository.DietRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DietOptionService
{
    private final DietOptionRepository dietOptionRepository;
    private final DietRepository dietRepository;

    public List<DietOption> findAll(Integer dietId)
    {
        return dietOptionRepository.findByDiet_DietId(dietId);
    }

    public Optional<DietOption> save(Integer dietId, DietOptionDto dietOptionDto)
    {
        return dietRepository
                .findById(dietId)
                .map(dietOptionDto::toEntityWith)
                .map(dietOptionRepository::save);
    }

    @Transactional
    public Optional<DietOption> update(Integer id, DietOptionDto dietOptionDto)
    {
        return dietOptionRepository
                .findById(id)
                .map(dietOption -> updateDietOption(dietOption, dietOptionDto));
    }

    private DietOption updateDietOption(DietOption dietOption, DietOptionDto dietOptionDto)
    {
        dietOption.setName(dietOptionDto.getName());
        dietOption.setAbbreviation(dietOptionDto.getAbbreviation());
        return dietOption;
    }
}
