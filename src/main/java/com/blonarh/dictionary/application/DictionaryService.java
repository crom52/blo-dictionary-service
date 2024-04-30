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

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DictionaryService {
    DictionaryRepository dictionaryRepository;
    TopicDictionaryRepository topicDictionaryRepository;

    @Transactional
    public List<Dictionary> insertDictionaries(List<Dictionary> dictionaries) {
        return dictionaryRepository.saveAll(dictionaries);
    }

    @Transactional
    public List<Dictionary> updateDictionaries(List<Dictionary> dictionaries) {
        return dictionaryRepository.saveAll(dictionaries);
    }

    @Transactional
    public Object upsertDictionariesByTopics(@RequestBody List<TopicDictionaryInsertReq> dictionaries) {
        List<TopicDictionary> topicDictionaryList = new ArrayList<>();
        for (TopicDictionaryInsertReq dic : dictionaries) {
            fillContentHtml(dic);
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

    private void fillContentHtml(Dictionary dictionary) {
        String content = dictionary.getContent();
        if (isBlank(content) || equalsIgnoreCase(content, dictionary.getContentHtml())) {
            return;
        }
        dictionary.setContentHtml("<p>" + content + "</p>");
    }
}
