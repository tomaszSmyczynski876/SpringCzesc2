package pl.example.spring.punkty.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.example.spring.punkty.Models.NewStudent;
import pl.example.spring.punkty.Models.Score;
import pl.example.spring.punkty.Models.Student;
import pl.example.spring.punkty.NoStudentException;
import pl.example.spring.punkty.Services.StudentService;


import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    private final StudentService service;

    public PunktyController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
        return service.getStudents();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(@RequestBody NewStudent student) {
        return service.addStudent(student);
    }

    @RequestMapping(value = "/students/{id}/number/{number}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student setNumber(@PathVariable("id") long id, @PathVariable("number") String number) {
        return service.changeNumber(id,number).orElseThrow(()->new NoStudentException(id));
    }

    @RequestMapping(value = "/students/{id}/scores", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addScore(@PathVariable("id") long id, @RequestBody Score score){
       return this.service.addScore(id, score).orElseThrow(()->new NoStudentException(id));
    }

}
