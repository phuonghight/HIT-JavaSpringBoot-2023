package exercise06.Repository;

import exercise06.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE phone p SET p.name = ?2, p.student_id = ?3 WHERE p.id = ?1", nativeQuery = true)
    void updateById(int id, String name, int student_id);
}
