package pl.example.spring.punkty.Models;


public class Student {
    public Long id;
    public String name;
    public String number;
    public String grupa;

    public Student() {
    }

    public Student(Long id, String name, String number, String grupa) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.grupa = grupa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }
}
