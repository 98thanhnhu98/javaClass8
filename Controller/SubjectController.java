package com.example.Example2.Controller;

import com.example.Example2.Service.SubjectService;
import com.example.Example2.mode.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/Subjectdetall",method = RequestMethod.GET)    //(DONE)  GET ALL
    public ResponseEntity<List<Subject>>listResponseEntity(){
        List<Subject> list = subjectService.getAllSubject();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/studentdetall/name/{name}",method = RequestMethod.GET)    //(DONE)
    public ResponseEntity<Subject> findSubjectByName(@PathVariable("name")String name){
        Subject u = (Subject) subjectService.findSubjectByName(name);
        return new ResponseEntity<Subject>(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/big/sem/{sem}/{name}",method = RequestMethod.GET)    //(DONE)
    public ResponseEntity<Subject> findSubjectBySem(@PathVariable("sem")long sem,@PathVariable("name")String name){
        Subject u = subjectService.findSubjectBySem(sem,name);
        return new ResponseEntity<Subject>(u,HttpStatus.OK);
    }

    @RequestMapping(value = "/Subjectdetall/{id}" , method = RequestMethod.GET)     //(DONE)  GET ID
    public ResponseEntity<Subject> getSubjectByID(@PathVariable("id") long id){
        Subject subject = subjectService.getOneSubject(id);
        return new ResponseEntity<Subject>(subject,HttpStatus.OK);
    }

    @RequestMapping(value = "/Subjectdetall/save", method = RequestMethod.POST)    //(DONE)
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
        return ResponseEntity.ok(subject);
    }

    @RequestMapping(value = "/Subjectdetall/update/{id}", method = RequestMethod.POST)  //(DONE)
    public ResponseEntity<Subject> updateSubject(@PathVariable("id")long id, @RequestBody Subject subject){

        Subject oldSubject = subjectService.getOneSubject(id);
        if (oldSubject == null){
            return ResponseEntity.notFound().build();
        } else {
            oldSubject.setName(subject.getName());
            oldSubject.setDescription(subject.getDescription());
            oldSubject.setSem((int) subject.getSem());
            oldSubject.setTime((int) subject.getTime());
            subjectService.saveSubject(subject);
            return ResponseEntity.ok(oldSubject);
        }
    }

    @RequestMapping(value = "/Subjectdetall/delete/{id}", method = RequestMethod.DELETE)   //(DONE)
    public ResponseEntity<Subject> deleteStudent(@PathVariable("id") long id){
        Optional<Subject> _olderStudent = subjectService.findSubjectById(id);
        if (_olderStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            subjectService.deleteSubject(id);
            return ResponseEntity.ok().build();
        }
    }

}
