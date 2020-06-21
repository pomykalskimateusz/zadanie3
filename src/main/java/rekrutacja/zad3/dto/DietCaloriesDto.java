package rekrutacja.zad3.dto;

import lombok.Data;
import rekrutacja.zad3.entity.DietCalories;
import rekrutacja.zad3.entity.DietOption;

@Data
public class DietCaloriesDto
{
    private Integer calories;

    public DietCalories toEntityWith(DietOption dietOption)
    {
        return DietCalories
                .builder()
                .calories(calories)
                .dietOption(dietOption)
                .build();
    }
}
