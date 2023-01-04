package edu.fei.piecing.Service;

import edu.fei.piecing.Model.Student;
import edu.fei.piecing.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Optional<Student> findById(Integer id){
        return studentRepository.findById(id);
    }




}
