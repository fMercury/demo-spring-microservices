package demo.spring.microservices.classroom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.microservices.classroom.controller.feign.StudentClient;
import demo.spring.microservices.classroom.exceptions.ClassroomNotFoundException;
import demo.spring.microservices.classroom.model.Classroom;
import demo.spring.microservices.classroom.model.Student;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

	@Autowired
	private StudentClient studentClient;

	private List<Classroom> classrooms;

	public ClassroomController() {
		classrooms = new ArrayList<>();
		classrooms.add(new Classroom(1, "Class1"));
		classrooms.add(new Classroom(2, "Class2"));
		classrooms.add(new Classroom(3, "Class3"));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/name/{name}")
	public Classroom findByName(@PathVariable("name") String name) throws ClassroomNotFoundException {
		return classrooms.stream().filter(classroom -> classroom.getName().equals(name))
				.findFirst().orElseThrow(() -> new ClassroomNotFoundException(name));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Classroom> findAll() {
		return classrooms;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Classroom findById(@PathVariable("id") Integer id) {
		Classroom classroom = classrooms.stream()
				.filter(it -> it.getId().intValue() == id.intValue())
				.findFirst().get();
		List<Student> students = studentClient.getStudents(id);
		classroom.setStudents(students);
		return classroom;
	}

}
