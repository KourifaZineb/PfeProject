package ma.pfe.dtos;

import ma.pfe.entities.StudentEntity;

import java.util.List;

public class StudentDto {
    private StudentIdDto idStudent;
    private  String name;
    private AdresseDto adresse;
    private List<CourseDto> courses;
    public StudentIdDto getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(StudentIdDto idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", adresse=" + adresse +
                ", courses=" + courses +
                '}';
    }
}