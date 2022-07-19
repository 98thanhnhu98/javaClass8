package com.example.Example2.Service;

import com.example.Example2.mode.Subject;
import com.example.Example2.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceIML implements SubjectService {
    @Autowired
    SubjectRepository repository;

    @Override
    public List<Subject> getAllSubject() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public void saveSubject(Subject subject) {
        repository.save(subject);
    }
    @Override
    public void deleteSubject(long id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<Subject> findSubjectById(long id) {
        return repository.findById(id);
    }

    @Override
    public Subject findSubjectByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Subject findSubjectBySem(long sem,String name) {
        return repository.findByNameAndSem(name,sem);
    }

    @Override
    public Long getCountByName() {
        return repository.getCountByName();
    }

    @Override
    public Long countSubjectBySem(long sem) {
        return repository.countSubjectsBySem(sem);
    }

    @Override
    public Subject getOneSubject(long id) {
        return repository.findById(id).get();
    }
}
