package com.example.Example2.Service;


import com.example.Example2.mode.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface SubjectService {
    List<Subject> getAllSubject();
    void saveSubject(Subject subject);
    void deleteSubject(long id);
    Optional<Subject> findSubjectById(long id);
    Subject findSubjectByName(String name);
    Subject findSubjectBySem(long sem,String name);

    Subject getOneSubject(long id);
}
