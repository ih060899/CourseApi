package com.imran.javabrains.course;

import java.util.List;
import java.util.Optional;

import com.imran.javabrains.topic.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics/{topicId}/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(@PathVariable int topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);

    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int id, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        course.setId(id);
        courseService.updateCourse(course);

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
