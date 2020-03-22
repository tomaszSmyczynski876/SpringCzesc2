package pl.example.spring.punkty.Services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.example.spring.punkty.Models.*;
import pl.example.spring.punkty.Repository.ScoreRepository;
import pl.example.spring.punkty.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository repository, ScoreRepository scoreRepository) {
        this.studentRepository = repository;
        this.scoreRepository = scoreRepository;
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(studentROw -> students.add(studentROw.toSdudent()));
        return students;
    }

    public Student addStudent(NewStudent student) {
        StudentROw save = this.studentRepository.save(new StudentROw(student.getName(), student.getNumber(), student.getGrupa()));
        return save.toSdudent();
    }

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentROw> student=this.studentRepository.findById(studentId);
        return student.map(studentROw -> {
            studentROw.setNumber(newNumber);
            return studentROw.toSdudent();
        });
    }

    @Transactional
    public Optional<Integer> addScore(final long studentId, final Score score) {
        final Optional<StudentROw> student = this.studentRepository.findById(studentId);
        return student.map(studentROw -> {
            final int sum = studentROw.getScores().stream().mapToInt(ScoreRow::getScore).sum();
            final ScoreRow newScore=new ScoreRow(score.getScore(), score.getComment(), student.orElseThrow());
            this.scoreRepository.save(newScore);
            return sum + newScore.getScore();
        });

    }

}
