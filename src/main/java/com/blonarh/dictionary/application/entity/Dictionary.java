package com.blonarh.dictionary.application.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class Dictionary extends BaseEntity {
    @Id
    @GeneratedValue
    UUID id;
    String canonical;
    String canonicalNormalized;
    String thumbnailUrl;
    Integer thumbnailWidth;
    Integer thumbnailHeight;
    String content;
    String contentHtml;
    String contentUrl;
}
