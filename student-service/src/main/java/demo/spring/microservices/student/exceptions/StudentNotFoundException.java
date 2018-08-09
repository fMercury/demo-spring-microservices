package demo.spring.microservices.student.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String student) {
		super(String.format("Student %s not found.", student));
	}
	
}
