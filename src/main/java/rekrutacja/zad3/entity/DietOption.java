package rekrutacja.zad3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Diet diet;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "dietOption", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietCalories> dietCalories = new ArrayList<>();;
}
