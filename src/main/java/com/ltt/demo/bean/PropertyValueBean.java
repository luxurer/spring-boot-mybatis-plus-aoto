package com.ltt.demo.bean;

import lombok.Data;

@Data
public class PropertyValueBean {
   private  String name;
   private  String value;
   private int type;
   void setName(String name){
       this.name=name;
   }
}
