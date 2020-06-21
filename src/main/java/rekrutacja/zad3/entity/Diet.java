package rekrutacja.zad3.entity;

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
public class Diet {
    @Id
    @GeneratedValue
    private Integer dietId;

    private String name;

    private String description;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietOption> dietOptions = new ArrayList<>();
}
