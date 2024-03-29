package com.example.wbdvsp20xiaohaiserverjava.services;

import com.example.wbdvsp20xiaohaiserverjava.models.Topic;
import com.example.wbdvsp20xiaohaiserverjava.models.Widget;
import com.example.wbdvsp20xiaohaiserverjava.repositories.TopicRepository;
import com.example.wbdvsp20xiaohaiserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public List<Topic> findAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }

    public Topic findTopicById(Integer tid) {
        return topicRepository.findTopicById(tid);
    }

    public int deleteTopic(Integer tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public int updateTopic(Integer tid, Topic updatedTopic) {
        Topic oldTopic = topicRepository.findTopicById(tid);
        oldTopic.setTitle(updatedTopic.getTitle());
        oldTopic.setDescription(updatedTopic.getDescription());

        topicRepository.save(oldTopic);
        return 1;
    }

    public Topic createTopic(Topic newTopic) {
        return topicRepository.save(newTopic);
    }

    public Widget createWidgetForTopic(
            Integer tid,
            Widget newWidget) {
        Topic topic = topicRepository.findTopicById(tid);
        //Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }
}
