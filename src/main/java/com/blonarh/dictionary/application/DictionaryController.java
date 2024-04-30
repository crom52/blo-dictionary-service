package com.blonarh.dictionary.application;

import com.blonarh.dictionary.application.dto.TopicDictionaryInsertReq;
import com.blonarh.dictionary.application.entity.Dictionary;
import com.blonarh.dictionary.application.entity.TopicDictionary;
import com.blonarh.dictionary.application.repository.DictionaryRepository;
import com.blonarh.dictionary.application.repository.TopicDictionaryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DictionaryController {
    DictionaryService dictionaryService;
    DictionaryRepository dictionaryRepository;
    TopicDictionaryRepository topicDictionaryRepository;

    @PostMapping("dictionaries")
    public List<Dictionary> insertDictionaries(List<Dictionary> dictionary) {
        return dictionaryService.insertDictionaries(dictionary);
    }

    @PutMapping("dictionaries")
    public List<Dictionary> updateDictionaries(List<Dictionary> dictionary) {
        return dictionaryService.updateDictionaries(dictionary);
    }

    @PostMapping("/topic/dictionaries")
    Object upsertDictionariesByTopic(@RequestBody List<TopicDictionaryInsertReq> request) {
        return dictionaryService.upsertDictionariesByTopics(request);
    }

    @GetMapping("topic/dictionaries")
    List<TopicDictionary> findDictionariesByTopics(@RequestParam("topic_ids") List<String> topicIds) {
        return topicDictionaryRepository.findTopicDictionariesByTopicIds(topicIds);
    }

    @GetMapping("dictionaries")
    List<TopicDictionary> findAllDictionaries(@RequestParam List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return topicDictionaryRepository.findAll();
        }

        return topicDictionaryRepository.findAllById(ids);
    }

    @GetMapping("dictionary/{id}")
    Dictionary findDictionaryById(@PathVariable String id) {
        return dictionaryRepository.findById(UUID.fromString(id)).orElseGet(Dictionary::new);
    }
}
