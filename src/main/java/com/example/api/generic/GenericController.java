package com.example.api.generic;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericController<T, ID extends Serializable> {

	@Autowired
	GenericRepository<T, ID> repository;
}
