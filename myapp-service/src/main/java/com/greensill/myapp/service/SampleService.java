package com.greensill.myapp.service;

import com.greensill.myapp.dto.ModelDto;
import com.greensill.myapp.exception.EntityNotFoundException;

public interface SampleService {

	/**
	 * Create a sample model
	 * 
	 * @param model
	 * @return
	 */
	ModelDto createModel(ModelDto model);

	/**
	 * Find a model by a unique identifier
	 * 
	 * @param id
	 * @return
	 * @throws EntityNotFoundException
	 *             when the model has not been found
	 */
	ModelDto findModelById(Long id) throws EntityNotFoundException;

}
