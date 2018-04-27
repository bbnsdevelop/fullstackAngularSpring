package br.com.fullstackAngularSpring.service.impl.pessoa;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.PessoaEntityBuilder;
import br.com.fullstackAngularSpring.builders.PessoaResponseBuilder;
import br.com.fullstackAngularSpring.exceptions.PessoaException;
import br.com.fullstackAngularSpring.model.endereco.Endereco;
import br.com.fullstackAngularSpring.model.pessoa.Pessoa;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@Service
public class PessoaImpl implements PessoaService{
	
	private PessoaRepository pessoaRepository;
	private MessageSource menssageSource;
	
	@Autowired
	public PessoaImpl(PessoaRepository pessoaRepository, MessageSource menssageSource) {
		super();
		this.pessoaRepository = pessoaRepository;
		this.menssageSource = menssageSource;
	}
	
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

	@Override
	public PessoaResponse upDatePessoa(PessoaRequest request) {
		if(isNull(request.getId())) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-update-id", null, LocaleContextHolder.getLocale()));
		}
		List<Endereco> enderecos = pessoaRepository.findById(request.getId()).get().getEnderecos();
		PessoaEntityBuilder pessoaBuilder = PessoaEntityBuilder.create()
				.id(request.getId())
				.cpf(request.getCpf())
				.dataNascimento(request.getDataNascimento())
				.nome(request.getNome())
				.rg(request.getRg());
		Pessoa pessoa = pessoaBuilder.build();
		pessoa.setEnderecos(enderecos);
		pessoa = pessoaRepository.save(pessoa);
		PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
				.id(pessoa.getId())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.nome(pessoa.getNome())
				.rg(pessoa.getRg());
		return pessoaResponseBuilder.build();
	}

	@Override
	public PessoaResponse buscaPorId(Long id) {
		if(isNull(id)) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-id", null, LocaleContextHolder.getLocale()));
		}
		Pessoa pessoa = pessoaRepository.getOne(id);
		if(isNull(pessoa.getId())) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-pessoa-null", null, LocaleContextHolder.getLocale()));
		}
		PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
				.id(pessoa.getId())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.nome(pessoa.getNome())
				.rg(pessoa.getRg());
		return pessoaResponseBuilder.build();
	}

}
