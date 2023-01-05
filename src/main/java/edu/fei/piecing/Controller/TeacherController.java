package edu.fei.piecing.Controller;

import edu.fei.piecing.Model.Teacher;
import edu.fei.piecing.Repository.TeacherRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    TeacherRepository teacherRepository;
    @GetMapping public ResponseEntity<String> getAll(){

        return new ResponseEntity<>(teacherRepository.toString(), HttpStatus.OK);
    }
    @PostMapping public ResponseEntity<String> addTeacher(@RequestParam String name,@RequestParam String pwd){
        if(name == null && pwd == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Teacher n = new Teacher();
        n.setName(name);
        n.setPwd(pwd);
        teacherRepository.save(n);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
