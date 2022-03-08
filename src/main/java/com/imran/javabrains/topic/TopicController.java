package com.imran.javabrains.topic;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicservice;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicservice.getAllTopics();
    }

    @GetMapping("{id}")
    public Optional<Topic> getTopic(@PathVariable int id) {
        return topicservice.getTopic(id);
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicservice.addTopic(topic);

    }

    @PutMapping("/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
        topic.setId(id);
        topicservice.updateTopic(id, topic);

    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicservice.deleteTopic(id);
    }

}
