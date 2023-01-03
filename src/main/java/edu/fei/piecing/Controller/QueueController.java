package edu.fei.piecing.Controller;

import edu.fei.piecing.Repository.StudentRepository;
import edu.fei.piecing.Service.Lifo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {
    @Autowired
    private StudentRepository studentRepository;

    Lifo lifo = new Lifo();
    @PostMapping("/add")
    ResponseEntity<String> addToStack(@RequestParam("id")Integer id){
        if(id < 0){
            return new ResponseEntity<>("Our Api Does NOT Accept negative values", HttpStatus.BAD_REQUEST);
        }
        lifo.pushToStack(id);
        return new ResponseEntity<>("User Added to queue",HttpStatus.CREATED);
    }
    @GetMapping("/getQueueNum")
    ResponseEntity<String> getPosInStack(@RequestParam("id")Integer id){
        return new ResponseEntity<String>("{Id :"+"\""+lifo.getIndex(id)+"\"}",HttpStatus.OK);
    }
    @GetMapping ResponseEntity<String> getQueue(){
        return new ResponseEntity<String>(lifo.getStringStack(),HttpStatus.OK);
    }
    @GetMapping("/getStud/{id}") ResponseEntity<String> getStudentFromRepo(@PathVariable Integer id){

        return new ResponseEntity<String>(studentRepository.findById(id).toString(),HttpStatus.OK);
    }
}
