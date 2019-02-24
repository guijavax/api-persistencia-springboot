package com.example.api.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericController<T, ID extends Serializable> {

	@Autowired
	GenericRepository<T, ID> repository;
	
	protected T save(T entity) {
		T t = repository.save(entity);
		return t;
	}
	
	protected List<T> findAll() {
		return repository.findAll();
	}
	
	protected T findById(Long id) {
		return repository.findOne(id);
	}
	
	protected T update(T t) {
		return repository.saveAndFlush(t);
	}
	
	protected void deleteByid(Long id) {
		repository.delete(id);
	}
}
