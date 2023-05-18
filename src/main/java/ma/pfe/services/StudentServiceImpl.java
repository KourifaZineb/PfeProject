package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service1")
public class StudentServiceImpl implements StudentService{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;
    private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    public StudentServiceImpl(@Qualifier("repo1") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*@Override
    public Long save(StudentDto dto) {
        LOGGER.debug("start method save dto : {}", dto);
        LOGGER.debug("mapping dto to entity : {}", studentMapper.convertToEntity(dto));
        StudentDto result = studentMapper.convertToDto(studentRepository.save(studentMapper.convertToEntity(dto)));
        return result.getIdStudent().getId();
    }*/

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("start method save dto : {}", dto);
        LOGGER.debug("mapping dto to entity : {}", studentMapper.convertToEntity(dto));
        return studentRepository.save(studentMapper.convertToEntity(dto)).getIdStudent().getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("start method update dto : {}", dto);
        StudentDto result = studentMapper.convertToDto(studentRepository.save(studentMapper.convertToEntity(dto)));
        return result.getIdStudent().getId();
    }

    @Override
    public Boolean deletById(StudentIdDto idDto) {
        LOGGER.debug("start method deleteById idDto : {}", idDto);
        studentRepository.deleteById(studentMapper.studentIdDtoToStudentId(idDto));
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("start method selectAll");
        return studentMapper.convertToDtos(studentRepository.findAll());
    }

   @Override
    public StudentDto selectById(StudentIdDto idDto) {
        // Mapper StudentIdDto -> StudentIdDto
        Optional result = studentRepository.findById(studentMapper.studentIdDtoToStudentId(idDto));
        return studentMapper.convertToDto((StudentEntity) result.orElse(null));

    }
}
