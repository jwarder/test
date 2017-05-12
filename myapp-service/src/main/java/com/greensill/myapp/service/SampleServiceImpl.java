package com.greensill.myapp.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greensill.myapp.dto.ModelDto;
import com.greensill.myapp.entity.ModelEntity;
import com.greensill.myapp.exception.EntityNotFoundException;
import com.greensill.myapp.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleRepository repository;

	@Autowired
	private Mapper mapper;

	@Override
	public ModelDto createModel(ModelDto model) {
		return mapper.map(repository.save(mapper.map(model, ModelEntity.class)), ModelDto.class);
	}

	@Override
	public ModelDto findModelById(Long id) {
		ModelEntity entity = repository.findOne(id);
		if (entity == null) {
			String message = String.format("Model with ID [ %d ] does not exists", id);
			throw new EntityNotFoundException(message);
		}
		return mapper.map(entity, ModelDto.class);
	}

}
