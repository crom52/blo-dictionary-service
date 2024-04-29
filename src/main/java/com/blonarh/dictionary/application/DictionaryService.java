package com.blonarh.dictionary.application;

import com.blonarh.dictionary.application.dto.TopicDictionaryInsertReq;
import com.blonarh.dictionary.application.entity.Dictionary;
import com.blonarh.dictionary.application.entity.TopicDictionary;
import com.blonarh.dictionary.application.repository.DictionaryRepository;
import com.blonarh.dictionary.application.repository.TopicDictionaryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DictionaryService {
    DictionaryRepository dictionaryRepository;
    TopicDictionaryRepository topicDictionaryRepository;

    public List<Dictionary> insertDictionaries(List<Dictionary> dictionaries) {
        return dictionaryRepository.saveAll(dictionaries);
    }

    public List<Dictionary> updateDictionaries(List<Dictionary> dictionaries) {
        return dictionaryRepository.saveAll(dictionaries);
    }

    @Transactional
    public Object upsertDictionariesByTopic(@RequestBody List<TopicDictionaryInsertReq> dictionaries) {
        List<TopicDictionary> topicDictionaryList = new ArrayList<>();
        for (TopicDictionaryInsertReq dic : dictionaries) {
            Dictionary savedDic = dictionaryRepository.saveAndFlush(dic);

            TopicDictionary topicDic = TopicDictionary.builder().topicId(dic.getTopicId())
                                                      .dictionaryId(savedDic.getId()).topicName(dic.getTopicName())
                                                      .dictionaryCanonical(savedDic.getCanonical())
                                                      .contentHtml(savedDic.getContentHtml())
                                                      .contentUrl(savedDic.getContentUrl())
                                                      .thumbnailWidth(savedDic.getThumbnailWidth())
                                                      .thumbnailHeight(savedDic.getThumbnailHeight()).build();
            topicDictionaryList.add(topicDic);
        }
        return topicDictionaryRepository.saveAll(topicDictionaryList);
    }
}
