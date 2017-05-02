package aula114.spring.domain;

import java.util.LinkedList;

public class User {
	private int id;
	private String firstName;
	private Integer age;
	//private LinkedList<Post> posts = new LinkedList<Post>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
/*	public LinkedList<Post> getPosts() {
		return posts;
	}
	public void setPosts(LinkedList<Post> posts) {
		this.posts = posts;
	}*/

}
