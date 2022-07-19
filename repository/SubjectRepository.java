package com.example.Example2.repository;

import com.example.Example2.mode.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByOrderByIdAsc();
    Subject findByName(String name);
    Subject findByNameAndSem(String name , long sem);
}
