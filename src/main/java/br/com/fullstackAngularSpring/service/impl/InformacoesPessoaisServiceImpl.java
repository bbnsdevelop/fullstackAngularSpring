package br.com.fullstackAngularSpring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.EnderecoResponseBuilder;
import br.com.fullstackAngularSpring.builders.PessoaResponseBuilder;
import br.com.fullstackAngularSpring.model.Pessoa;
import br.com.fullstackAngularSpring.repository.PessoaRepository;
import br.com.fullstackAngularSpring.rest.response.DadosPessoaisResponse;
import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.InformacoesPessoaisService;

@Service
public class InformacoesPessoaisServiceImpl implements InformacoesPessoaisService{
	
	private static final Logger log = LoggerFactory.getLogger(InformacoesPessoaisServiceImpl.class);
	
	private List<EnderecoResponse> enderecos; 
	private PessoaResponse pessoaResponse; 
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public DadosPessoaisResponse infoAll() {
		log.info("buscando informações dos usuários");
		DadosPessoaisResponse info = new DadosPessoaisResponse();
		this.enderecos = new ArrayList<>();
		List<PessoaResponse> pessoas =  new ArrayList<>();
		pessoaRepository.findAll().stream().forEach(dados ->{
			dados.getEnderecos().stream().forEach(end ->{
				EnderecoResponseBuilder endBuilderResponse = EnderecoResponseBuilder.create()
						.id(end.getCodigo())
						.logradouro(end.getLogradouro())
						.numero(end.getNumero())
						.complemento(end.getComplemento() != null ? end.getComplemento() : "")
						.bairro(end.getBairro())
						.cep(end.getCep())
						.localidade(end.getCidade())
						.uf(end.getEstado())
						.pessoaId(end.getPessoa().getId())
						.enderecoPrincipal(end.getFlagEnderecoPrincipal());
				this.enderecos.add(endBuilderResponse.build());				
			});
			PessoaResponseBuilder pessoaBuilderResponse = PessoaResponseBuilder.create()
					.id(dados.getId())
					.nome(dados.getNome())
					.rg(dados.getRg())
					.cpf(dados.getCpf())
					.dataNascimento(dados.getDataNascimento())
					.enderecos(enderecos);			
			pessoas.add(pessoaBuilderResponse.build());
			this.enderecos = new ArrayList<>();
		});
		info.setPessoas(pessoas);
		return info;
	}

	@Override
	public PessoaResponse buscaPorCpf(String cpf) {
		log.info("buscando informações dos usuários por cpf: " + cpf);
		Pessoa pessoa = pessoaRepository.findByCpf(cpf);		
		this.enderecos = new ArrayList<>();
		pessoa.getEnderecos().stream().forEach(end ->{
			EnderecoResponseBuilder endBuilderResponse = EnderecoResponseBuilder.create()
					.id(end.getCodigo())
					.logradouro(end.getLogradouro())
					.numero(end.getNumero())
					.complemento(end.getComplemento() != null ? end.getComplemento() : "")
					.bairro(end.getBairro())
					.cep(end.getCep())
					.localidade(end.getCidade())
					.uf(end.getEstado())
					.pessoaId(end.getPessoa().getId())
					.enderecoPrincipal(end.getFlagEnderecoPrincipal());
			this.enderecos.add(endBuilderResponse.build());	
			PessoaResponseBuilder pessoaBuilderResponse = PessoaResponseBuilder.create()
					.id(pessoa.getId())
					.nome(pessoa.getNome())
					.rg(pessoa.getRg())
					.cpf(pessoa.getCpf())
					.dataNascimento(pessoa.getDataNascimento())
					.enderecos(enderecos);			
			this.pessoaResponse = pessoaBuilderResponse.build();
		});
		return this.pessoaResponse;
	}

}
