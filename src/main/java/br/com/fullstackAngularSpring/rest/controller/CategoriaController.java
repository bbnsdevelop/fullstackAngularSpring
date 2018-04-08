package br.com.fullstackAngularSpring.rest.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;
import br.com.fullstackAngularSpring.rest.resource.CategoriaResource;
import br.com.fullstackAngularSpring.service.categoria.CategoriaService;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaController implements CategoriaResource{
	
	@Autowired
	CategoriaService categoriaService;
	
	@Override
	@GetMapping
	public ResponseEntity<?> getAllCategoria() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAll()); 
	}
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getByCategoria(@PathVariable("id") @Validated @NotNull(message ="Id Obrigatório") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getById(id));
	}
	@Override
	@PostMapping
	public ResponseEntity<Void> setCategoria(@RequestBody @Validated CategoriaRequest requeste, HttpServletResponse response) {
		categoriaService.create(requeste);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
