package br.com.fullstackAngularSpring.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.request.LancamentoRequest;
import br.com.fullstackAngularSpring.rest.resource.LancamentoResource;
import br.com.fullstackAngularSpring.service.lancamento.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController implements LancamentoResource{

	@Autowired
	LancamentoService lancamentoService;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaLancamentoPorPessoa(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findByPessoa(id));
	}

	@Override
	@GetMapping()
	public ResponseEntity<?> buscaLancamentos() {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findByPessoa(id));
	}

	@Override
	@PostMapping("/{id}")
	public ResponseEntity<?> salvarLancamento(@Valid @RequestBody LancamentoRequest request, @PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.saveLancamento(id, request));
	}

	@Override
	public ResponseEntity<?> salvarLancamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
