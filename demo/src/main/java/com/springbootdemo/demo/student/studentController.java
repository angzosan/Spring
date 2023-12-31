package com.springbootdemo.demo.student;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "api/v1/student")
public class studentController {

    private final studentService studentService;

    @Autowired
    public studentController(studentService studentService){
        this.studentService =  studentService;
	}
  

      @GetMapping
	public List<student> getStudents(){
        return studentService.getStudents();
	}

    @PostMapping
  public void register(@RequestBody student student){
    studentService.addNewStudent(student);
  }

    @DeleteMapping(path = "{id}")
  public void delete(@PathVariable("id") Long id){
    studentService.deleteStudent(id);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(
    @PathVariable("studentId") Long id,
    @RequestParam(required = false) String name,
     @RequestParam(required = false) String email) {
      studentService.updateStudent(id,name,email);
     }

  
    
  
    
}
