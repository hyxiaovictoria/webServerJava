package com.example.wbdvsp20xiaohaiserverjava.controllers;

import com.example.wbdvsp20xiaohaiserverjava.models.Topic;
import com.example.wbdvsp20xiaohaiserverjava.models.Widget;
import com.example.wbdvsp20xiaohaiserverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopicForLesson(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic newTopic
    ) {
        newTopic.setLessonId(lessonId);
        return topicService.createTopic(newTopic);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") String lessonId) {
        return topicService.findTopicsForLesson(lessonId);
    }

    @PutMapping("/api/topics/{tid}")
    public int updateTopic(@PathVariable("tid") int topicId,
                            @RequestBody Topic topic) {
        return topicService.updateTopic(topicId, topic);
    }

    @DeleteMapping("/api/topics/{tid}")
    public int deleteTopic(@PathVariable("tid") int topicId) {
        return topicService.deleteTopic(topicId);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId") int tid) {
        return topicService.findTopicById(tid);
    }

//    // DO NOT USE THIS - ONLY FOR ACADEMIC PURPOSE
//    @GetMapping("/api/topics/{tid}/widgets/create")
//    public Widget createWidgetForTopicBad(
//            @PathVariable("tid") Integer tid) {
//        Widget newWidget = new Widget();
//        newWidget.setTitle("Dont do this");
//        newWidget.setSize(111);
//        return topicService.createWidgetForTopic(tid, newWidget);
//    }
//
//    @PostMapping("/api/topics/{tid}/widgetseee")
//    public Widget createWidgetForTopic(
//            @PathVariable("tid") Integer tid,
//            @RequestBody Widget newWidget) {
//        return topicService.createWidgetForTopic(tid, newWidget);
//    }
}
