package pl.example.spring.punkty.Services;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.example.spring.punkty.Models.NewStudent;
import pl.example.spring.punkty.Models.Student;
import pl.example.spring.punkty.Repository.ScoreRepository;
import pl.example.spring.punkty.Repository.StudentRepository;


import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ScoreRepository scoreRepository;

    private StudentService service;

    @Before
    public void init(){

        service=new StudentService(repository, scoreRepository);
        this.repository.deleteAll();

    }

    @Test
    public void getEmptyList(){
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void addStudents(){
        Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned(){
        NewStudent student = new NewStudent("Student1","1-2-3","IP");
        Student getStudent = service.addStudent(student);
        final List<Student> all = service.getStudents();
        assertTrue(all.contains(getStudent));
    }

    @Test
    public void addStudentHasNewId(){
        NewStudent student = new NewStudent("Student1","1-2-3","IP");
        Student student1 = service.addStudent(student);
        Student student2 = service.addStudent(student);
        assertNotEquals(student1.id, student2.id);
        assertEquals(2,service.getStudents().size());

    }
}