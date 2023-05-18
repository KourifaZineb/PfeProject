package ma.pfe.entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class StudentEntity {
  @EmbeddedId
  private StudentId idStudent;
  @Column(name = "name_student")
  private String name;

  //Remove kathayad lina student o kathayad m3ah hta les cours li 3ando
  //Refresh kadir lina la mise a jour 3la hssab dakchi li kayn f la base ywli 3andna f context de persistence
  //Merge 3andha 2 role lawal huwa dir lina l'insertion o tani huwa dir lina update b dakchi li f context de persistence ywli f la base
  //Persist katsayb lina parent table 3ad tsayb lina children table
  //Detache kathayad lina la liaison li 3and l'objet li kain f le context de persistence m3a la base
  //All katjm3hom kamlin hadi makhasnach ndiroha hit fiha remove o t9der thayad lina les donnees

  //fetch lazy howa li kayjib lina les donnes dyal kola table bohdha bhal hna dar 2 requettes wahda dyal select student o lakhra dyal select cours
  //fetch eager howa li kayjib lina les donnes dyal les tables b2 f da9a bhal hna dar requette wahda

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "list_course_student")
    private List<CourseEntity> courses;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue", column = @Column(name = "rue_student")),
            @AttributeOverride(name = "avenue", column = @Column(name = "avenue_student")),
            @AttributeOverride(name = "number", column = @Column(name = "number_student"))
    })

    private Adresse adresse;

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public StudentId getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(StudentId idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", adresse=" + adresse +
                '}';
    }
}
