package com.amazon.amazonagencyrestapitask.entity.user;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public abstract class BaseEntity {
    @Id
    private String id;
}
