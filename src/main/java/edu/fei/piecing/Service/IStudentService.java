package edu.fei.piecing.Service;

import edu.fei.piecing.Model.Student;

import java.util.Optional;

public interface IStudentService {
    Optional<Student> findById(Integer id);
}
