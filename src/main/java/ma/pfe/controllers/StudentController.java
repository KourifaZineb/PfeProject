package ma.pfe.controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ma.pfe.dtos.StudentDto;
import ma.pfe.repositories.StudentRepositoryImpl;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Student")
@RestController

public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService service;
    @PostMapping("/save")
    public Long save (StudentDto dto){
        LOGGER.debug("start method save");
        return service.save(dto);
    }

    @PutMapping("/update")
    public Boolean update(StudentDto dto){
        LOGGER.debug("start method update");
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public Boolean delete(Long id){
        LOGGER.debug("start method delete");
        return service.deletById(id);
    }

    @GetMapping("/selectAll")
    public List<StudentDto> selectAll(){
        LOGGER.debug("start method selectAll");
        return service.selectAll();
    }
}
