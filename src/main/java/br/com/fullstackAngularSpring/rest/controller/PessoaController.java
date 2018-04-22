package br.com.fullstackAngularSpring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.resource.PessoaResource;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController implements PessoaResource{
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	@PostMapping
	public ResponseEntity<?> cadastroPessoa(@Validated @RequestBody PessoaRequest pessoa) {
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.criar(pessoa));
	}

	@Override
	public ResponseEntity<?> atualizaPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletaPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<PessoaResponse>> buscaTodasPessoas() {		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAll());
	}
	
}
