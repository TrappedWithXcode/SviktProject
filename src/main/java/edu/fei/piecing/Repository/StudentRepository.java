package edu.fei.piecing.Repository;

import edu.fei.piecing.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student> findByNameEqualsAndPwd(String studentName,String pwd);
}
