package com.healthtracker.service;

import com.healthtracker.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {

    List<E> findAll();

    E findById(Long id);

    E save(E entity);

    void delete(Long id);
}
