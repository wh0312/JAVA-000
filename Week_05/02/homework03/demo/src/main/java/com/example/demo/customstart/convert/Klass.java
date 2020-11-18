package com.example.demo.customstart.convert;

import lombok.Data;

import java.util.List;

@Data
public class Klass {
    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void dong(){
        System.out.println(this.getStudents());
    }
}
