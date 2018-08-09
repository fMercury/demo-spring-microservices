package demo.spring.microservices.student.model;

public class Student {

	private Integer id;
	private Integer classroomId;
	private String name;

	public Student() {

	}

	public Student(Integer id, Integer classroomId, String name) {
		this.id = id;
		this.classroomId = classroomId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
