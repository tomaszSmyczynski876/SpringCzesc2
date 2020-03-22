package pl.example.spring.punkty.Repository;

import org.springframework.data.repository.CrudRepository;
import pl.example.spring.punkty.Models.StudentROw;

public interface StudentRepository extends CrudRepository<StudentROw,Long> {


}
