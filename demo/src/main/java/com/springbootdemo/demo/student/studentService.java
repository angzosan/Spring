package com.springbootdemo.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class studentService {

    private final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents(){
	  return studentRepository.findAll();
	}

    public void addNewStudent(student student) {
        Optional<student> studentByEmail = 
        studentRepository.findstudentByEmail(student.getEmail());
        if  (studentByEmail.isPresent()){
          throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
        if (! studentRepository.existsById(id) ){
            throw new IllegalStateException("student with id : " + id + " already exists.");
           }
           studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
         student student = studentRepository.findById(id).orElseThrow( () -> new IllegalStateException(( "student with id: "+ id + " does not exist.")));

            if (name != null && name.length() > 0 && 
                 !Objects.equals(student.getName(), name)){
                    student.setName(name);
                 }

             if (email != null && email.length() > 0 && 
                 !Objects.equals(student.getEmail(), email)){
                    Optional<student> studentOptional =studentRepository.findstudentByEmail(email);
                     if (studentOptional.isPresent()){
                        throw new IllegalStateException("email taken");
                     }
                     student.setEmail(email);
                 }
    }
    
}
