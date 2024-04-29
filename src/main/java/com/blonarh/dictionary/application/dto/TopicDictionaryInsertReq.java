package com.blonarh.dictionary.application.dto;

import com.blonarh.dictionary.application.entity.Dictionary;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Transient;

@Getter
@Setter
@SuperBuilder
public class TopicDictionaryInsertReq extends Dictionary {
    @Transient
    String topicId;

    @Transient
    String topicName;
}
