package edu.fei.piecing.Repository;


import edu.fei.piecing.Model.Teacher;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Integer> {
    List<Teacher> findByNameEqualsAndPwdEquals(String studentName, String pwd);
    Teacher findByQueueNumEquals(Integer queueNum);
    Teacher findTeacherByUid(Integer uid);
}
