package com.example.osms.dao;
import com.example.osms.model.Student;
import java.util.List;
public interface StudentDAO{
 void save(Student s);
 Student get(int id);
 List<Student> list();
 void update(Student s);
 void delete(int id);
}
