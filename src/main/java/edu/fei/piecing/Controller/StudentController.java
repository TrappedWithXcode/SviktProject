package edu.fei.piecing.Controller;

import edu.fei.piecing.Model.Student;
import edu.fei.piecing.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/demo")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping(path = "/add")
    public @ResponseBody String addNewStudent (@RequestParam String name,@RequestParam String email){
        Student n = new Student();
        n.setName(name);
        n.setClss(email);
        studentRepository.save(n);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllUsers(){
        return studentRepository.findAll();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String name,@RequestParam String pwd){
        if(studentRepository.findByNameEqualsAndPwd(name,pwd).isEmpty()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/login");
            return new ResponseEntity<>("\"redirect\": \"/login\"",headers,HttpStatus.TEMPORARY_REDIRECT);
        }
        return new ResponseEntity<>(studentRepository.findByNameEqualsAndPwd(name,pwd).toString(), HttpStatus.OK);
    }

}
