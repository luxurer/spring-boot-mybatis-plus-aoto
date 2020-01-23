package com.ltt.demo.bean;

import com.ltt.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBean {
   private  Student student;
   private  List<Attribute> list=new ArrayList<Attribute>();
   void setStudent(Student student) {
       this.student=student;
   }
   public Student getStudent(){
       return this.student;
   }
   void setList(List<Attribute> list){
       this.list=list;
   }
    public List<Attribute> getList(){
       return list;
    }
}
