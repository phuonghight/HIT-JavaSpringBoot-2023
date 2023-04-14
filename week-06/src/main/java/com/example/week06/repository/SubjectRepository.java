package com.example.week06.repository;

import com.example.week06.entity.Phone;
import com.example.week06.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
