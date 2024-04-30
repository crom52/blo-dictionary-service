package com.blonarh.dictionary.application.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@JsonNaming(value = SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicDictionary extends BaseEntity {
    @Id
    @GeneratedValue
    UUID id;
    String topicId;
    UUID dictionaryId;
    String topicName;
    String dictionaryCanonical;
    String contentHtml;
    String contentUrl;
    String thumbnailUrl;
    Integer thumbnailWidth;
    Integer thumbnailHeight;
}
