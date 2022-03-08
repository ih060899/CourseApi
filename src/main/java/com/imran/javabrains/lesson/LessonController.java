package com.imran.javabrains.lesson;

import java.util.List;
import java.util.Optional;

import com.imran.javabrains.course.Course;

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
@RequestMapping("courses/{courseId}/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonservice;

    @GetMapping
    public List<Lesson> getAllLessons(@PathVariable int courseId) {
        return lessonservice.getAllLesson(courseId);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> getLesson(@PathVariable int id) {
        return lessonservice.getLesson(id);
    }

    @PostMapping
    public void addLesson(@RequestBody Lesson lesson, @PathVariable int courseId) {
        lesson.setCourse(new Course(courseId, "", "", 0));
        lessonservice.addLesson(lesson);

    }

    @PutMapping("/{id}")
    public void updateTopic(@RequestBody Lesson course, @PathVariable int id, @PathVariable int courseId) {
        course.setCourse(new Course(courseId, "", "", 0));
        course.setId(id);
        lessonservice.updateLesson(course);

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        lessonservice.deleteLesson(id);
    }
}
