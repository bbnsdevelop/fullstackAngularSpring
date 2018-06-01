package br.com.fullstackAngularSpring.service.impl;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.EnderecoEntityBuilder;
import br.com.fullstackAngularSpring.builders.EnderecoResponseBuilder;
import br.com.fullstackAngularSpring.builders.PessoaEntityBuilder;
import br.com.fullstackAngularSpring.builders.PessoaResponseBuilder;
import br.com.fullstackAngularSpring.enumerator.PessoaEnum;
import br.com.fullstackAngularSpring.exceptions.PessoaException;
import br.com.fullstackAngularSpring.model.Endereco;
import br.com.fullstackAngularSpring.model.Pessoa;
import br.com.fullstackAngularSpring.repository.EnderecoRepository;
import br.com.fullstackAngularSpring.repository.PessoaRepository;
import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.PessoaService;

@Service
public class PessoaImpl implements PessoaService{
	private static final Logger log = LoggerFactory.getLogger(PessoaImpl.class);
	private PessoaRepository pessoaRepository;
	private MessageSource menssageSource;
	private Pessoa pessoa;
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	public PessoaImpl(PessoaRepository pessoaRepository, MessageSource menssageSource, EnderecoRepository enderecoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.menssageSource = menssageSource;
		this.enderecoRepository = enderecoRepository;
	}
	
	@Override
	public PessoaResponse criar(PessoaRequest request) {
		log.info("Salvando pessoa");
		PessoaEntityBuilder pessoaBuilder = PessoaEntityBuilder.create()
				.cpf(request.getCpf())
				.dataNascimento(request.getDataNascimento())
				.nome(request.getNome())
				.rg(request.getRg())
				.ativo(request.getAtivo());
		Pessoa pessoa = pessoaRepository.save(pessoaBuilder.build());
		PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
				.id(pessoa.getId())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.nome(pessoa.getNome())
				.rg(pessoa.getRg())
				.ativo(pessoa.getFlagAtivo());
		PessoaResponse response = pessoaResponseBuilder.build();
		List<Endereco> enderecos = new ArrayList<>();
		if(null != request.getEnderecos()) {
			log.info("Validando endereço da pessoa");
			request.getEnderecos().stream().forEach(end ->{
				EnderecoEntityBuilder endBuilder = EnderecoEntityBuilder.create()
						.bairro(end.getBairro())
						.cep(end.getCep())
						.complemento(end.getComplemento())
						.enderecoPrincipal(end.getEnderecoPrincipal())
						.id(end.getId())
						.localidade(end.getLocalidade())
						.logradouro(end.getLogradouro())
						.numero(end.getNumero())
						.pessoa(pessoa)
						.uf(end.getUf());
				enderecos.add(endBuilder.build());
			});
			log.info("Salvando endereço pessoa");
			pessoa.setEnderecos(enderecoRepository.saveAll(enderecos));
		}
		List<EnderecoResponse> enderecosResponse = new ArrayList<>();
		if(null != pessoa.getEnderecos()) {
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
				enderecosResponse.add(endBuilderResponse.build());	
			});
			response.setEnderecos(enderecosResponse);
		}
		return response;
	}

	@Override
	public List<PessoaResponse> getAll() {
		log.info("buscando todas as pessoas");
		List<PessoaResponse> pessoas = new ArrayList<>();
		pessoaRepository.findAll().stream().forEach(p ->{
			PessoaResponseBuilder builder = PessoaResponseBuilder.create()
			.id(p.getId())
			.nome(p.getNome())
			.cpf(p.getCpf())
			.dataNascimento(p.getDataNascimento())
			.rg(p.getRg())
			.ativo(p.getFlagAtivo());
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
		log.info("Atualizando dados da pessoa");
		if(isNull(request.getId())) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-update-id", null, LocaleContextHolder.getLocale()));
		}
		List<Endereco> enderecos = pessoaRepository.findById(request.getId()).get().getEnderecos();
		PessoaEntityBuilder pessoaBuilder = PessoaEntityBuilder.create()
				.id(request.getId())
				.cpf(request.getCpf())
				.dataNascimento(request.getDataNascimento())
				.nome(request.getNome())
				.rg(request.getRg())
				.ativo(request.getAtivo());
		Pessoa pessoa = pessoaBuilder.build();
		pessoa.setEnderecos(enderecos);
		pessoa = pessoaRepository.save(pessoa);
		PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
				.id(pessoa.getId())
				.cpf(pessoa.getCpf())
				.dataNascimento(pessoa.getDataNascimento())
				.nome(pessoa.getNome())
				.rg(pessoa.getRg())
				.ativo(pessoa.getFlagAtivo());
		return pessoaResponseBuilder.build();
	}

	@Override
	public PessoaResponse buscaPorId(Long id) {
		log.info("Buscando pessoa por id: " + id);
		List<EnderecoResponse> enderecos = new ArrayList<>();
		if(isNull(id)) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-id", null, LocaleContextHolder.getLocale()));
		}
		Pessoa pessoa = pessoaRepository.findById(id).get();
		if(pessoa.getFlagAtivo().equals(PessoaEnum.ATIVO.getValor())) {
			PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
					.id(pessoa.getId())
					.cpf(pessoa.getCpf())
					.dataNascimento(pessoa.getDataNascimento())
					.nome(pessoa.getNome())
					.rg(pessoa.getRg());
			PessoaResponse response = pessoaResponseBuilder.build();
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
				enderecos.add(endBuilderResponse.build());	
			});
			response.setEnderecos(enderecos);
			return response;
		}
		return null;
	}

	@Override
	public PessoaResponse upDatePessoa(Long id, PessoaRequest request) {
		log.info("Atualizando dados da pessoa");
		this.pessoa = new Pessoa();
		if(isNull(id)) {
			throw new PessoaException(menssageSource.getMessage("mensagem.erro-update-id", null, LocaleContextHolder.getLocale()));
		}
		PessoaEntityBuilder pessoaBuilder = PessoaEntityBuilder.create()
				.id(request.getId())
				.cpf(request.getCpf())
				.dataNascimento(request.getDataNascimento())
				.nome(request.getNome())
				.rg(request.getRg())
				.ativo(request.getAtivo());
		this.pessoa = pessoaBuilder.build();
		this.pessoa.setId(id);
		if(null != request.getEnderecos()) {
			List<Endereco> enderecos = new ArrayList<>();
			request.getEnderecos().stream().forEach(end ->{
				EnderecoEntityBuilder endBuilder = EnderecoEntityBuilder.create()
						.bairro(end.getBairro())
						.cep(end.getCep())
						.complemento(end.getComplemento())
						.enderecoPrincipal(end.getEnderecoPrincipal())
						.id(end.getId())
						.localidade(end.getLocalidade())
						.logradouro(end.getLogradouro())
						.numero(end.getNumero())
						.pessoa(this.pessoa)
						.uf(end.getUf());
				enderecos.add(enderecoRepository.save(endBuilder.build()));
			});
			this.pessoa.setEnderecos(enderecos);		
		}		
		Pessoa pessoaSalva = pessoaRepository.findById(id).get();
		if(null == this.pessoa.getEnderecos()) {
			this.pessoa.setEnderecos(pessoaSalva.getEnderecos());
		}		
		BeanUtils.copyProperties(this.pessoa, pessoaSalva);
		Pessoa pessoa = pessoaRepository.save(pessoaSalva);
		if(pessoa.getFlagAtivo().equals(PessoaEnum.ATIVO.getValor())) {
			List<EnderecoResponse> listaEnderecos = new ArrayList<>();
			PessoaResponseBuilder pessoaResponseBuilder = PessoaResponseBuilder.create()
					.id(pessoa.getId())
					.cpf(pessoa.getCpf())
					.dataNascimento(pessoa.getDataNascimento())
					.nome(pessoa.getNome())
					.rg(pessoa.getRg())
					.ativo(pessoa.getFlagAtivo());
			PessoaResponse response = pessoaResponseBuilder.build();
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
				listaEnderecos.add(endBuilderResponse.build());	
			});
			response.setEnderecos(listaEnderecos);
			return response;			
		}
		return null;
	}

}