package br.com.fullstackAngularSpring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.resource.BuscaInformacoesPessoaisResourse;
import br.com.fullstackAngularSpring.rest.response.DadosPessoaisResponse;
import br.com.fullstackAngularSpring.service.info.InformacoesPessoaisService;

@RestController
@RequestMapping("/dados-pessoais")
public class BuscaInformacoesPessoaisController implements BuscaInformacoesPessoaisResourse{

	@Autowired
	InformacoesPessoaisService informacoesPessoaisService;
	
	@Override
	@GetMapping
	public ResponseEntity<DadosPessoaisResponse> buscaInformacoes() {
		return ResponseEntity.status(HttpStatus.OK).body(informacoesPessoaisService.infoAll());
	}

	@Override
	@GetMapping("/{cpf}")
	public ResponseEntity<?> buscaInformacoesPorCpf(@PathVariable("cpf") String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(informacoesPessoaisService.buscaPorCpf(cpf));
	}

}
