package demo.spring.microservices.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.microservices.student.exceptions.StudentNotFoundException;
import demo.spring.microservices.student.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	private List<Student> students;

	public StudentController() {
		students = new ArrayList<>();
		students.add(new Student(1, 1, "Student1"));
		students.add(new Student(2, 1, "Student2"));
		students.add(new Student(3, 2, "Student3"));
		students.add(new Student(4, 2, "Student4"));
		students.add(new Student(5, 3, "Student5"));
		students.add(new Student(6, 3, "Student6"));
		students.add(new Student(7, 2, "Student7"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{name}")
	public Student findByNumber(@PathVariable("name") String name) throws StudentNotFoundException {
		return students.stream().filter(it -> it.getName().equals(name))
				.findFirst().orElseThrow(() -> new StudentNotFoundException("name"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/classroom/{classroom}")
	public List<Student> findByClassroom(@PathVariable("classroom") Integer classroomId) {
		return students.stream()
				.filter(student -> student.getClassroomId().equals(classroomId))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> findAll() {
		return students;
	}

}
