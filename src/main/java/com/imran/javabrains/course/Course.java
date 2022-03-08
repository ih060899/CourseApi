package com.imran.javabrains.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.imran.javabrains.topic.Topic;

@Entity
@Table(name = "course")
public class Course {
    @Id
    private int id;
    private String name;
    private String description;

    // @JoinColumn(name = "topic_id")
    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(int id, String name, String description, int topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
