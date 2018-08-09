package demo.spring.microservices.classroom.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class ClassroomNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClassroomNotFoundException(String name) {
		super(String.format("Classroom % not found.", name));
	}
	
}
