package com.amazon.amazonagencyrestapitask.repository;

import com.amazon.amazonagencyrestapitask.entity.user.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends MongoRepository<E, String> {
}
