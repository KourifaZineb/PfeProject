package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;

import java.util.List;

public interface StudentService {
    Long save(StudentDto dto);
    Long update(StudentDto dto);
    Boolean deletById(StudentIdDto idDto);
    List<StudentDto> selectAll();
    StudentDto selectById(StudentIdDto idcomp);

}
