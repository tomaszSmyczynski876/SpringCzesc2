package pl.example.spring.punkty;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoStudentException extends RuntimeException {

    public NoStudentException(long id) {
        super("Stent o id: "+id+" does not exists");
    }
}
