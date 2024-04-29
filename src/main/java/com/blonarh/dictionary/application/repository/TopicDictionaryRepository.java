package com.blonarh.dictionary.application.repository;

import com.blonarh.dictionary.application.entity.TopicDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDictionaryRepository extends JpaRepository<TopicDictionary, String> {

}
