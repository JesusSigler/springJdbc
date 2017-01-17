package aula114.spring.app;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import aula114.spring.domain.User;
import aula114.spring.dao.UserDAO;

public class UserApp {

   private static Logger logger = Logger.getLogger(UserApp.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
		"classpath:META-INF/spring/applicationContext.xml");
   // DataSource datasource = ctx.getBean("dataSource",DataSource.class);
    //JdbcTemplate template = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
    UserDAO userDao = ctx.getBean("userDAO",UserDAO.class);
    //JdbcTemplate template = new JdbcTemplate(datasource);
      String sql = "select * from user";
      //List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
      logger.info("Consultando tabla User");
      List<User> userList = userDao.findAll();
      for (User user : userList) {
         System.out.println(user.getFirstName());
         System.out.println(user.getAge());
      }
      // ahora insertando en tabla User
      logger.info("Insertando en tabla User");
      User user = new User();
      user.setFirstName("Isabel");
      user.setAge(45);
      userDao.add(user);

      ctx.close();
  }
}

