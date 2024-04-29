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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class BaseEntity {
    Long createdDt;
    Long updatedDt;
    String createdBy;
    String updatedBy;
}
