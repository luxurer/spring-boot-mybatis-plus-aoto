package com.ltt.demo.bean;

public class Attribute {
   private  String name;
   private  String value;
   void setName(String name){
       this.name=name;
   }
   public String getName(){
       return name;
   }
   void setValue(String value){
       this.value=value;
   }
   public String getValue(){
       return value;
   }
}
