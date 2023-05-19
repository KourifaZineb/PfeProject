package ma.pfe.dtos;

public class CourseDto {


    private long id;
    private String nom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
