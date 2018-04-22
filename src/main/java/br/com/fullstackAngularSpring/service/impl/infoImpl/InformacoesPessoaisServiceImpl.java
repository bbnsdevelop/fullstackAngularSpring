package br.com.fullstackAngularSpring.service.impl.infoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.EnderecoResponseBuilder;
import br.com.fullstackAngularSpring.builders.PessoaResponseBuilder;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.rest.response.DadosPessoaisResponse;
import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.info.InformacoesPessoaisService;

@Service
public class InformacoesPessoaisServiceImpl implements InformacoesPessoaisService{
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public DadosPessoaisResponse infoAll() {
		DadosPessoaisResponse info = new DadosPessoaisResponse();
		List<EnderecoResponse> enderecos = new ArrayList<>();
		List<PessoaResponse> pessoas =  new ArrayList<>();
		pessoaRepository.findAll().stream().forEach(dados ->{
			PessoaResponseBuilder pessoaBuilderResponse = PessoaResponseBuilder.create()
					.id(dados.getId())
					.nome(dados.getNome())
					.rg(dados.getRg())
					.cpf(dados.getCpf())
					.dataNascimento(dados.getDataNascimento());
			pessoas.add(pessoaBuilderResponse.build());
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
				enderecos.add(endBuilderResponse.build());				
			});
		});
		pessoas.stream().filter(p -> p.getId().equals() )
		info.setPessoas(pessoas);
		//info.getPessoas().
		return info;
	}

}
