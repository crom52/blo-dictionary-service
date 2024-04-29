package com.blonarh.dictionary.application;

import com.blonarh.dictionary.application.dto.TopicDictionaryInsertReq;
import com.blonarh.dictionary.application.entity.Dictionary;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DictionaryController {
    DictionaryService dictionaryService;

    @PostMapping("dictionaries")
    public List<Dictionary> insertDictionaries(List<Dictionary> dictionary) {
        return dictionaryService.insertDictionaries(dictionary);
    }

    @PutMapping("dictionaries")
    public List<Dictionary> updateDictionaries(List<Dictionary> dictionary) {
        return dictionaryService.updateDictionaries(dictionary);
    }

    @PostMapping("/topic-dictionaries")
    public Object upsertDictionariesByTopic(List<TopicDictionaryInsertReq> request) {
        return dictionaryService.upsertDictionariesByTopic(request);
    }

}
