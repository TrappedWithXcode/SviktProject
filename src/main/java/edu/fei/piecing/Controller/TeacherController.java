package edu.fei.piecing.Controller;

import edu.fei.piecing.Model.Teacher;
import edu.fei.piecing.Repository.TeacherRepository;
import edu.fei.piecing.Service.Fifo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.net.URI;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    Fifo fifo;
    @Autowired
    TeacherRepository teacherRepository;
    @GetMapping public ResponseEntity<String> getAll(){
        if(teacherRepository == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(teacherRepository.findAll().toString(), HttpStatus.OK);
    }
    @PostMapping public ResponseEntity<String> addTeacher(@RequestParam String name, @RequestParam String pwd,@RequestParam Integer queue){
        if(name == null && pwd == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Teacher n = new Teacher();
        n.setName(name);
        n.setPwd(pwd);
        n.setQueueNum(queue);
        teacherRepository.save(n);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @PostMapping("/addQueueRef") public  ResponseEntity<String> addQueueRef(@RequestParam Integer uid){
        if(uid == null ) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        var teacher = teacherRepository.findTeacherByUid(uid);
        if (fifo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        teacher.setQueueNum(fifo.getFirst());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path ="/login") public ResponseEntity<String> login(@RequestParam String name, @RequestParam String pwd){
        var teacher = teacherRepository.findByNameEqualsAndPwdEquals(name,pwd);
        if(teacher.isEmpty()){

            HttpHeaders header = new HttpHeaders();
            header.add("Location","http://localhost:3000/");
            return new ResponseEntity<>(header,HttpStatus.TEMPORARY_REDIRECT);

        }
        return new ResponseEntity<>(teacher.toString(),HttpStatus.OK);
    }
}
