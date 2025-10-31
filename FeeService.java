package com.example.osms.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.osms.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.osms.model.Student;

@Service
public class FeeService {
 @Autowired
 private StudentDAO dao;
 @Transactional
 public void pay(int id,double amt){
   Student s=dao.get(id);
   s.setBalance(s.getBalance()+amt);
   dao.update(s);
 }
 @Transactional
 public void refund(int id,double amt){
   Student s=dao.get(id);
   s.setBalance(s.getBalance()-amt);
   dao.update(s);
 }
}
