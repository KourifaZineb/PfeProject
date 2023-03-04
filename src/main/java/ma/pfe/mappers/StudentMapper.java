package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentEntity convertToEntity(StudentDto d){
        StudentEntity entity=new StudentEntity();
        entity.setId(d.getId());
        entity.setName(d.getName());
        return entity;
    }
    public StudentDto convertToDto(StudentEntity e){
        StudentDto dto=new StudentDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        return dto;
    }
    public List<StudentEntity> convertToEntities(List<StudentDto> dtos){
        return dtos.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }
    public List<StudentDto> convertToDtos(List<StudentEntity> entities){
        return entities.stream().map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }
}
