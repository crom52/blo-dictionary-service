package com.blonarh.dictionary.application.repository;

import com.blonarh.dictionary.application.entity.TopicDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicDictionaryRepository extends JpaRepository<TopicDictionary, String> {
    @Query("select td from TopicDictionary td where 1=1" +
            " and (:topicIds is null or td.topicId in (:topicIds)) ")
    List<TopicDictionary> findTopicDictionariesByTopicIds(List<String> topicIds);

}
