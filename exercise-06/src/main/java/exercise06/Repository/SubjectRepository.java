package exercise06.Repository;

import exercise06.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query(value = "SELECT * FROM subject s WHERE s.student_id = ?1", nativeQuery = true)
    List<Subject> getAllSubjectsByStudentId(int id);
}
