package rekrutacja.zad3.dto;

import lombok.Data;

import rekrutacja.zad3.entity.Diet;

@Data
public class DietDto
{
    private String name;
    private String description;

    public Diet toEntity()
    {
        return Diet
                .builder()
                .name(name)
                .description(description)
                .build();
    }
}
