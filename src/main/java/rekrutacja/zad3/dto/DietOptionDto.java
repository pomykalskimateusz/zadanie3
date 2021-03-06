package rekrutacja.zad3.dto;

import lombok.Data;

import rekrutacja.zad3.entity.Diet;
import rekrutacja.zad3.entity.DietOption;

@Data
public class DietOptionDto
{
    private String name;
    private String abbreviation;

    public DietOption toEntityWith(Diet diet)
    {
        return DietOption
                .builder()
                .name(name)
                .abbreviation(abbreviation)
                .diet(diet)
                .build();
    }
}
