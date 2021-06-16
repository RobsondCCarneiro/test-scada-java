package com.caern.scadabr.test.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caern.scadabr.test.entities.ScadaBR;
import com.caern.scadabr.test.repositories.ScadaBRRepositories;

@RestController
@RequestMapping(value = "/scadabr")
public class ScadaBRResource {

	@Autowired
	private ScadaBRRepositories repository;
	
	@GetMapping
	public ResponseEntity<List<ScadaBR>> findAll(){
		List<ScadaBR> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
}
