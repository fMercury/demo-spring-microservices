package demo.spring.microservices.classroom.controller.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.microservices.classroom.model.Student;

@FeignClient("student-service")
public interface StudentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/students/classroom/{classroomId}")
    List<Student> getStudents(@PathVariable("classroomId") Integer classroomId);
    
}
