package rekrutacja.zad3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DietCalories {
    @Id
    @GeneratedValue
    private Integer dietCaloriesId;

    private Integer calories;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "diet_option_id", nullable = false)
    private DietOption dietOption;
}
