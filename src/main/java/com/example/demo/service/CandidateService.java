package com.example.demo.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
@CacheConfig(cacheNames = "candidateCache")
public class CandidateService {

	  private static Logger LOG = LoggerFactory.getLogger(CandidateService.class);
	  private static AtomicLong ID_CREATOR = new AtomicLong(0);

	  private Map<Long, Student> students;

	  public CandidateService() {
	    students = new ConcurrentHashMap<>();
	    students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "John", "Doe", "Computer Science"));
	    students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "Maria", "Thomson", "Information Systems"));
	    students.put(ID_CREATOR.incrementAndGet(), new Student(ID_CREATOR.get(), "Peter", "Simpson", "Mathematics"));
	  }

	  @Cacheable
	  public Optional<Student> find(Long id) {
	    LOG.info("Finding student with id '{}'", id);
	    return Optional.ofNullable(students.get(id));
	  }

	  @CachePut(key = "#result.id")
	  public Student create(String firstName, String lastName, String courseOfStudies) {
	    LOG.info("Creating student with firstName={}, lastName={} and courseOfStudies={}", firstName, lastName, courseOfStudies);
	    long newId = ID_CREATOR.incrementAndGet();
	    Student newStudent = new Student(newId, firstName, lastName, courseOfStudies);
	    students.put(newId, newStudent);

	    return newStudent;
	  }

}
