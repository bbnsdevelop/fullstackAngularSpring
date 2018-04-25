package br.com.fullstackAngularSpring.service.impl.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.PessoaEntityBuilder;
import br.com.fullstackAngularSpring.builders.PessoaResponseBuilder;
import br.com.fullstackAngularSpring.model.pessoa.Pessoa;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@Service
public class PessoaImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public PessoaResponse criar(PessoaRequest request) {
		PessoaEntityBuilder pessoaBuilder = PessoaEntityBuilder.create()
				.cpf(request.getCpf())
				.dataNascimento(request.getDataNascimento())
				.nome(request.getNome())
				.rg(request.getRg());
		Pessoa pessoa = pessoaRepository.save(pessoaBuilder.build());
		PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
				.id(pessoa.getId())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.nome(pessoa.getNome())
				.rg(pessoa.getRg());
		return pessoaResponseBuilder.build();
	}

	@Override
	public List<PessoaResponse> getAll() {
		List<PessoaResponse> pessoas = new ArrayList<>();
		pessoaRepository.findAll().stream().forEach(p ->{
			PessoaResponseBuilder builder = PessoaResponseBuilder.create()
			.id(p.getId())
			.nome(p.getNome())
			.cpf(p.getCpf())
			.dataNascimento(p.getDataNascimento())
			.rg(p.getRg());
			pessoas.add(builder.build());
		});
		return pessoas;
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);		
	}

}
