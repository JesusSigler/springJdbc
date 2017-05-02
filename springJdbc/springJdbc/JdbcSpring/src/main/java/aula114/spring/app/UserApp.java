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
		UserDAO userDao = ctx.getBean("userDAO", UserDAO.class);

		userDao.menu();

		ctx.close();
	}
}
