package com.example.osms;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.osms.config.AppConfig;
import com.example.osms.dao.StudentDAO;
import com.example.osms.model.Student;
import com.example.osms.service.FeeService;
import java.util.Scanner;

public class MainApp{
 public static void main(String[] args){
 AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
 StudentDAO dao=ctx.getBean(StudentDAO.class);
 FeeService fee=ctx.getBean(FeeService.class);
 Scanner sc=new Scanner(System.in);
 while(true){
   System.out.println("1 Add 2 List 3 Pay 4 Exit:");
   int c=sc.nextInt();
   if(c==1){
     System.out.print("Name:"); String n=sc.next();
     dao.save(new Student(n,0));
   }else if(c==2){
     dao.list().forEach(s-> System.out.println(s.getId()+" "+s.getName()+" Bal:"+s.getBalance()));
   }else if(c==3){
     System.out.print("ID:"); int i=sc.nextInt();
     System.out.print("Amt:"); double a=sc.nextDouble();
     fee.pay(i,a);
   }else break;
 }
 ctx.close();
 }
}
