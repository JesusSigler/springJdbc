package aula114.spring.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import aula114.spring.domain.User;

@Repository
public class UserDAO {

	private int option = 0;
	private boolean salir = false;
	private User user = new User();
	private String nombre = "";
	private int edad = 0;
	private int id = 0;

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() {
		do {
			try {

				System.out.println("1 Mostrar Lista de Personas");
				System.out.println("2 Insertar Persona");
				System.out.println("3 Borrar Persona");
				System.out.println("4 Actualizar Datos");
				System.out.println("0 Salir\n");

				while (!salir) {
					try {
						System.out.println("Introduce una opcion entre 0 y 4");
						option = Integer.parseInt(br.readLine());
						salir = true;
					} catch (NumberFormatException e) {
						System.out.println("No has introducido un numero, vuelve a introducir una opcion valida");
					}
				}
				salir = false;

				switch (option) {
				case 1:
					findAll();
					break;
				case 2:
					add(user);
					break;
				case 3:
					delete(user);

					break;
				case 4:
					update(user);

					break;
				case 0:
					break;

				default:
					System.out.println("Debes elegir una opcion entre 0 y 4\n");
					break;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} while (option != 0);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
    
    public List<User> findAll() {
    
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User u : userList) {
            System.out.println("Nombre: " + u.getFirstName() + "\nEdad: " + u.getAge() + "\n------------------");
        }
        return userList;
    }

	public void add(User user) {
		boolean salir = false;
		try {
			System.out.println("Introduce un nombre");
			nombre = br.readLine();
			user.setFirstName(nombre);
			do {
				try {
					System.out.println("Introduce la edad");
					this.edad = Integer.parseInt(br.readLine());
					salir = true;
				} catch (NumberFormatException e) {
					System.out.println("Error, debes escribir un valor numerico");
				}

			} while (!salir);
			user.setAge(edad);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String sql = "insert into user (first_name, age) values (?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getAge());
	}

	public void delete(User user) {
		try {
			System.out.println("Introduce el nombre a borrar");
			nombre = br.readLine();
			user.setFirstName(nombre);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		String sql = "delete from user where first_name = '" + user.getFirstName() + "'";
		jdbcTemplate.update(sql);
	}

	public void update(User user) {
		boolean salir = false;
		try {
			System.out.println("Introduce un nombre");
			nombre = br.readLine();
			user.setFirstName(nombre);
			do {
				try {
					System.out.println("Introduce la edad");
					this.edad = Integer.parseInt(br.readLine());
					salir = true;
				} catch (NumberFormatException e) {
					System.out.println("Error, debes escribir un valor numerico");
				}

			} while (!salir);
			user.setAge(edad);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String sql = "update user set age = " + user.getAge()
				+ " where first_name = '" + user.getFirstName()+ "'";
		jdbcTemplate.update(sql);
	}

}
