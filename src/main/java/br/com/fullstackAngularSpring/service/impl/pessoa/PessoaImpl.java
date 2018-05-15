package br.com.fullstackAngularSpring.service.impl.pessoa;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

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
import br.com.fullstackAngularSpring.model.endereco.Endereco;
import br.com.fullstackAngularSpring.model.pessoa.Pessoa;
import br.com.fullstackAngularSpring.repository.endereco.EnderecoRepository;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@Service
public class PessoaImpl implements PessoaService{
	
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
		PessoaResponse response = pessoaResponseBuilder.build();
		List<Endereco> enderecos = new ArrayList<>();
		if(request.getEnderecos().size() > 0) {
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
			pessoa.setEnderecos(enderecoRepository.saveAll(enderecos));
		}
		List<EnderecoResponse> enderecosResponse = new ArrayList<>();
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
		return response;
		
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
