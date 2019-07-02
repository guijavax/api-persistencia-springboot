package com.example.api.generic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Query;

public class GenericController<T, ID extends Serializable> {

	@Autowired
	GenericRepository<T, ID> repository;
	
	@PersistenceContext
	EntityManager manager;
	
	protected T save(T entity) {
		return repository.save(entity);
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
	
	
	protected List<T> findByQuery(String query) {
		return manager.createQuery(query).getResultList();
	}
	
	protected void deleteById(Long id) throws EmptyResultDataAccessException {
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
