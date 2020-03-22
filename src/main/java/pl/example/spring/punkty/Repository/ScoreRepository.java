package pl.example.spring.punkty.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.example.spring.punkty.Models.ScoreRow;

public interface ScoreRepository extends CrudRepository<ScoreRow, Long> {
}
