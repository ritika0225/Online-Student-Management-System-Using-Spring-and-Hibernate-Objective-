package com.example.osms.config;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.Properties;
import com.example.osms.dao.StudentDAO;
import com.example.osms.dao.StudentDAOImpl;
import com.example.osms.service.FeeService;

@Configuration
@ComponentScan("com.example.osms")
public class AppConfig {
 @Bean
 public DataSource dataSource(){
   DriverManagerDataSource ds=new DriverManagerDataSource();
   ds.setDriverClassName("org.h2.Driver");
   ds.setUrl("jdbc:h2:~/osmsdb");
   ds.setUsername("sa");
   ds.setPassword("");
   return ds;
 }
 @Bean
 public LocalSessionFactoryBean sessionFactory(){
   LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
   factory.setDataSource(dataSource());
   factory.setPackagesToScan("com.example.osms.model");
   Properties props=new Properties();
   props.put("hibernate.hbm2ddl.auto","update");
   props.put("hibernate.show_sql","true");
   factory.setHibernateProperties(props);
   return factory;
 }
 @Bean
 public StudentDAO studentDAO(){ return new StudentDAOImpl(); }

 @Bean
 public FeeService feeService(){ return new FeeService(); }
}
