package br.com.fullstackAngularSpring.service.impl.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.model.pessoa.Pessoa;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.service.cep.CepService;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@Service
public class PessoaImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CepService cepService;


}
