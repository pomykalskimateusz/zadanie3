package rekrutacja.zad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rekrutacja.zad3.entity.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Integer> { }
