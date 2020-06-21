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

    public boolean delete(Integer id)
    {
        try
        {
            dietRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    @Transactional
    public Optional<Diet> update(Integer id, DietDto dietDto)
    {
        return dietRepository
                .findById(id)
                .map(diet -> updateDiet(diet, dietDto));
    }

    private Diet updateDiet(Diet diet, DietDto dietDto)
    {
        diet.setName(dietDto.getName());
        diet.setDescription(dietDto.getDescription());
        return diet;
    }
}
