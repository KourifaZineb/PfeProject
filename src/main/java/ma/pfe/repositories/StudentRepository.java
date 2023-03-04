package ma.pfe.repositories;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ma.pfe.entities.StudentEntity;

import java.util.List;

public interface StudentRepository {
    Long save(StudentEntity e);
    Boolean update(StudentEntity e);
    Boolean delete(Long id);
    List<StudentEntity> selectAll();
}
