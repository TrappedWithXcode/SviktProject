package edu.fei.piecing.Repository; //Grouping related classes (somethink like folder in a file directory), This is user-defined package...

import edu.fei.piecing.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;          // In this statements we imported from external librares framework

@Repository // Encapsulate the logic required to access data sources.
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
// In short They centralize common data access functionality, providing better maintainability and decoupling the infrastructure
// or technology used to access databases from the domain model layer