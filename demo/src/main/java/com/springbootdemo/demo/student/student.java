package com.springbootdemo.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;


@Entity
@Table  
public class student {

    
    @Id 
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )


    private long id;
    private String name;
    private LocalDate dob;
    private String email;
    @Transient
    private Integer age;

    public student() {
    }

    public student(Long id, String name, LocalDate dob, String email ){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public student(String name, LocalDate dob, String email){
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public Integer getAge(){
        return Period.between(this.dob,  LocalDate.now()).getYears();
    }


    public LocalDate getDob(){
        return dob;
    }


    public String getEmail(){
        return email;
    }

     public void setId(long id){
       this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setAge(Integer age){
        this.age = age;
    }


    public void setDob(LocalDate dob){
        this.dob =  dob;
    }


    public void setEmail(String email){
        this.email = email;
    }


    


    



    
}
