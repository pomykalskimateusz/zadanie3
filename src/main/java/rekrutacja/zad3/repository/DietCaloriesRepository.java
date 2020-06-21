package rekrutacja.zad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rekrutacja.zad3.entity.DietCalories;

import java.util.List;

@Repository
public interface DietCaloriesRepository extends JpaRepository<DietCalories, Integer>
{
    List<DietCalories> findByDietOptionId(Integer dietOptionId);
}
