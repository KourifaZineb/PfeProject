package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Student")
@RestController

public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Long save (@RequestBody  StudentDto dto){
        LOGGER.debug("start method save dto : {}", dto);
        return service.save(dto);
    }

    @PutMapping("/update")
    public Long update(@RequestBody StudentDto dto){
        LOGGER.debug("start method update dto : {}", dto);
        return service.update(dto);
    }

    @DeleteMapping("/{id}/{code}")
    public Boolean deleteById(@PathVariable("id") long id, @PathVariable("code") String code){
        LOGGER.debug("start method delete by id {} , code {}", id , code);
        StudentIdDto idcomp = new StudentIdDto(id,code);
        return service.deletById(idcomp);
    }

    @GetMapping("/selectAll")
    public List<StudentDto> selectAll(){
        LOGGER.debug("start method selectAll");
        return service.selectAll();
    }
    @GetMapping("/{id}/{code}")
    public StudentDto selectById(@PathVariable("id") long id, @PathVariable("code") String code){
        LOGGER.debug("start method select by id {} , code {}", id , code);
        StudentIdDto idcomp = new StudentIdDto(id,code);
        return service.selectById(idcomp);
    }
}
