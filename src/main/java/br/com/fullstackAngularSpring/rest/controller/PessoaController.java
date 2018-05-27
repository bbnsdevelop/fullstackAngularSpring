package br.com.fullstackAngularSpring.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.resource.PessoaResource;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.PessoaService;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController implements PessoaResource{
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	@PostMapping
	public ResponseEntity<?> cadastroPessoa(@Validated @RequestBody PessoaRequest pessoa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.criar(pessoa));
	}

	@Override
	@PutMapping()
	public ResponseEntity<?> atualizaPessoa(@Valid @RequestBody PessoaRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.upDatePessoa(request));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaPessoa(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<PessoaResponse>> buscaTodasPessoas() {		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaPessoaId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscaPorId(id));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> ativaDesativaPessoa(@PathVariable("id") Long id, @Valid @RequestBody PessoaRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.upDatePessoa(id, request));
	}
	
}
