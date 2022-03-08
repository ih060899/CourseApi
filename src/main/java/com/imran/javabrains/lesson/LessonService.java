package com.imran.javabrains.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private LessonRepository LessonRepository;

    public List<Lesson> getAllLesson(int courseId) {

        List<Lesson> lessons = new ArrayList<>();
        LessonRepository.findByCourseId(courseId).forEach(lessons::add);
        return lessons;
    }

    public Optional<Lesson> getLesson(int id) {

        return LessonRepository.findById(id);
    }

    public void addLesson(Lesson lesson) {
        LessonRepository.save(lesson);

    }

    public void updateLesson(Lesson lesson) {

        LessonRepository.save(lesson);

    }

    public void deleteLesson(int id) {

        LessonRepository.deleteById(id);

    }
}
