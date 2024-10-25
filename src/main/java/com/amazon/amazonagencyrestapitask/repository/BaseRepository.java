package com.amazon.amazonagencyrestapitask.repository;

import com.amazon.amazonagencyrestapitask.entity.user.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
