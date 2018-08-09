package demo.spring.microservices.classroom.model;

import java.util.List;

public class Classroom {

	private Integer id;
	private String name;
	private List<Student> students;

	public Classroom() {
		
	}
	
	public Classroom(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
