package com.ltt.demo.bean;

import com.ltt.demo.entity.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentBean extends Student{
   private  List<PropertyValueBean> list;
}
