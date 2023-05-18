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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
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
