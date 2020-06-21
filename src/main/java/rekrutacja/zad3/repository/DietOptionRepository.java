package rekrutacja.zad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rekrutacja.zad3.entity.DietOption;

import java.util.List;

@Repository
public interface DietOptionRepository extends JpaRepository<DietOption, Integer>
{
    List<DietOption> findByDiet_DietId(Integer dietId);
}
