package com.example.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entities.CategoriaEntity;
import com.example.api.generic.GenericController;


@RestController
@RequestMapping(value="/categoria")
public class CategoriaController extends GenericController<CategoriaEntity, Long> {
	
}
