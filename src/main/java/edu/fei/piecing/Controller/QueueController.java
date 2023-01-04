package edu.fei.piecing.Controller;

import edu.fei.piecing.Model.Student;
import edu.fei.piecing.Repository.StudentRepository;
import edu.fei.piecing.Service.IStudentService;
import edu.fei.piecing.Service.Lifo;

import edu.fei.piecing.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/queue")
public class QueueController {
    @Autowired
    private StudentRepository studentRepository;
    public Integer queuecurrentnum = 3;
    @Autowired
    private IStudentService iStudentService;
    public QueueController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }




    Lifo lifo = new Lifo();

    @GetMapping ResponseEntity<String> getQueue(){
        return new ResponseEntity<String>(lifo.getStringStack(),HttpStatus.OK);
    }
    @PostMapping("/add")
    ResponseEntity<String> addToStack(@RequestParam("id")Integer id){
        if(id < 0){
            return new ResponseEntity<>("Our Api Does NOT Accept negative values", HttpStatus.BAD_REQUEST);
        }
        var studref = iStudentService.findById(id);
        Student student = studref.get();
        queuecurrentnum += 1;
        student.setQueue(queuecurrentnum);
        studentRepository.save(student);
        lifo.addToStack(id);
        return new ResponseEntity<>("User Added to queue",HttpStatus.CREATED);
    }
    @GetMapping("/getQueueNum")
    ResponseEntity<String> getPosInStack(@RequestParam("id")Integer id){
        var studref = iStudentService.findById(id);
        Student student = studref.get();

        return new ResponseEntity<String>(
                student.getQueue().toString(),HttpStatus.OK);
    }

    @GetMapping("/getStud/{id}") ResponseEntity<String> getStudentFromRepo(@PathVariable Integer id){


        var studref = iStudentService.findById(id);
        Student student = studref.get();


        return new ResponseEntity<String>(studentRepository.findById(id).toString(),HttpStatus.OK);
    }
    @GetMapping("/acceptStudent") ResponseEntity<String> acceptStudent(){
        if(lifo.isEmpty()){
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
        var studId = lifo.popFromStack();

        var studRef = iStudentService.findById(studId);

        Student student = studRef.get();
        student.setQueue(null);
        return  new ResponseEntity<String>(student.toString(),HttpStatus.ACCEPTED);
    }
}
