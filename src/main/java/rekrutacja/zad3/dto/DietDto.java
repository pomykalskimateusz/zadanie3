package rekrutacja.zad3.dto;

import lombok.Data;
import rekrutacja.zad3.entity.Diet;

import java.util.Collections;

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
                .dietOptions(Collections.emptySet())
                .build();
    }
}
