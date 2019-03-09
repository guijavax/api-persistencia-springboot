package com.example.api.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

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
	
	protected void deleteByid(Long id) throws EmptyResultDataAccessException {
		try {
			repository.delete(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new EmptyResultDataAccessException(ex.getMessage(), Integer.valueOf(id.toString()));
		}
	}
	
	protected void deleteByGroup(List<ID> ids) {
		ids.forEach(id -> {
			if(repository.exists(id)) repository.delete(id);
		});
	}
}
