package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.CandidateService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/rest/students")
public class StudentRestController {

  private final StudentService studentService;
  private final CandidateService candidateService;

  @Autowired
  public StudentRestController(StudentService studentService, CandidateService candidateService) {
    this.studentService = studentService;
    this.candidateService = candidateService;
  }

  
  @GetMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public String get(@PathVariable Long id) {
    Optional<Student> student = studentService.find(id);

    if (student.isPresent()) {
      return student.get().toString();
    }

    return "";
  }

  @PostMapping(path = "/createStudents", produces = MediaType.TEXT_PLAIN_VALUE)
  public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String courseOfStudies) {
    Student newStudent = studentService.create(firstName, lastName, courseOfStudies);

    return newStudent.toString();
  }

  @PostMapping(path = "/createStudents", produces = MediaType.TEXT_PLAIN_VALUE)
  public Student createStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String courseOfStudies) {
    Student newStudent = studentService.create(firstName, lastName, courseOfStudies);
    return newStudent;
  }

  @GetMapping(path = "/getCandidate/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
  public String getCandidate(@PathVariable Long id) {
    Optional<Student> student = candidateService.find(id);

    if (student.isPresent()) {
      return student.get().toString();
    }

    return "";
  }

  @PostMapping(path = "/createCandidate", produces = MediaType.TEXT_PLAIN_VALUE)
  public String createCandidate(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String courseOfStudies) {
    Student newStudent = candidateService.create(firstName, lastName, courseOfStudies);

    return newStudent.toString();
  }  
}
