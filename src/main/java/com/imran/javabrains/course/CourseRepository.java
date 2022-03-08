package com.imran.javabrains.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findByTopicId(int topicId);

}
