package rekrutacja.zad3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DietOption {
    @Id
    @GeneratedValue
    private Integer dietOptionId;

    private String name;

    private String abbreviation;

    @JsonBackReference
    @ManyToOne
//    @JoinColumn(name = "diet_id", nullable = false)
    private Diet diet;

    @JsonManagedReference
    @OneToMany(mappedBy = "dietOption", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DietCalories> dietCalories;
}
