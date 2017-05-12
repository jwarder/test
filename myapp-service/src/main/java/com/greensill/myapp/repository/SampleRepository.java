package com.greensill.myapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.greensill.myapp.entity.ModelEntity;

public interface SampleRepository extends CrudRepository<ModelEntity, Long> {

}
