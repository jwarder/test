package com.greensill.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greensill.myapp.dto.ModelDto;
import com.greensill.myapp.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	private SampleService service;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello";
	}

	@RequestMapping(value = "/models", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ModelDto create(@RequestBody ModelDto model) {
		return service.createModel(model);
	}

	@RequestMapping(value = "/models/{id}", method = RequestMethod.GET)
	public ModelDto read(@PathVariable Long id) {
		return service.findModelById(id);
	}

}
