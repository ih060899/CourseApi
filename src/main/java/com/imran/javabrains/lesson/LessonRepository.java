package com.imran.javabrains.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    public List<Lesson> findByCourseId(int courseId);
}
