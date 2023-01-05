package edu.fei.piecing.Controller; //Grouping related classes (somethink like folder in a file directory), This is user-defined package...

import edu.fei.piecing.Model.Student;
import edu.fei.piecing.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // In this statements we imported from ours user-defined packages model and repository
                                                 // and from external librares frameworks
@RestController               //It covers  every aspect of communication between relational databases and the Java application
@RequestMapping("/demo")   //Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
public class StudentController { // The beginning of the main of the controller itself
    @Autowired  // The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration
    private StudentRepository studentRepository;
    @PostMapping(path = "/add")
    public @ResponseBody String addNewStudent (@RequestParam String name,@RequestParam String email){
        Student n = new Student(); //determination of variables
        n.setName(name);
        n.setClss(email);
        studentRepository.save(n);
        return "Saved"; //When everything worked return saved
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllUsers(){ return studentRepository.findAll();} // Printout of all students in repository

}
//The basic part of the program became this controller, which actually controls the student login, the list of all logins, etc...