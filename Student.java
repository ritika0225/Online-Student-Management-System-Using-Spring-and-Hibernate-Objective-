package com.example.osms.model;
import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String name;
 private double balance;
 public Student(){}
 public Student(String name,double balance){
   this.name=name; this.balance=balance;
 }
 public int getId(){ return id; }
 public String getName(){ return name; }
 public void setName(String n){ this.name=n; }
 public double getBalance(){ return balance; }
 public void setBalance(double b){ this.balance=b; }
}
