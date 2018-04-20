package br.com.fullstackAngularSpring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.resource.PessoaResource;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController implements PessoaResource{
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	@PostMapping
	public ResponseEntity<?> cadastroPessoa() {
		//pessoaService.criar();
		return null;
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
	public ResponseEntity<?> buscaPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

}
