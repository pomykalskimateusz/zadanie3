package rekrutacja.zad3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.repository.DietRepository;
import rekrutacja.zad3.dto.DietDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DietService
{
    private final DietRepository dietRepository;

    public List<Diet> findAll()
    {
        return dietRepository.findAll();
    }

    public Diet save(DietDto dietDto)
    {
        return dietRepository.save(dietDto.toEntity());
    }

    @Transactional
    public Optional<Diet> update(Integer id, DietDto dietDto)
    {
        Optional<Diet> optionalDiet = dietRepository.findById(id);

        if(optionalDiet.isPresent())
        {
            Diet diet = optionalDiet.get();
            diet.setName(dietDto.getName());
            diet.setDescription(dietDto.getDescription());

            return Optional.of(diet);
        } else return Optional.empty();
    }
}