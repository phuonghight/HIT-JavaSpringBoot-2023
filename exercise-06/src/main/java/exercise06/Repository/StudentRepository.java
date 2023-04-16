package exercise06.Repository;

import exercise06.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE student s SET s.name = ?2 WHERE s.id = ?1", nativeQuery = true)
    void updateStudentById(int id, String name);
}
