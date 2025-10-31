package com.example.osms.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.osms.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
 @Autowired
 private SessionFactory sessionFactory;
 private Session session(){ return sessionFactory.getCurrentSession();}
 public void save(Student s){ session().save(s); }
 public Student get(int id){ return session().get(Student.class,id); }
 public List<Student> list(){ return session().createQuery("from Student").list(); }
 public void update(Student s){ session().update(s); }
 public void delete(int id){ session().delete(get(id)); }
}
