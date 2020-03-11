package com.example.wbdvsp20xiaohaiserverjava.repositories;

import com.example.wbdvsp20xiaohaiserverjava.models.Topic;
import com.example.wbdvsp20xiaohaiserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
    public Topic findTopicById(
            @Param("topicId") int tid);

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    @Query(value = "SELECT * FROM topics WHERE topics.lesson_id=:lessonId", nativeQuery = true)
    public List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);
}
