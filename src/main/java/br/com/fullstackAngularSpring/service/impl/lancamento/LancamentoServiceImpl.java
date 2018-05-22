package br.com.fullstackAngularSpring.service.impl.lancamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.enumerator.PessoaEnum;
import br.com.fullstackAngularSpring.mapper.LancamentoMapper;
import br.com.fullstackAngularSpring.model.categoria.Categoria;
import br.com.fullstackAngularSpring.model.lancamento.Lancamento;
import br.com.fullstackAngularSpring.model.pessoa.Pessoa;
import br.com.fullstackAngularSpring.repository.categoria.CategoriaRepository;
import br.com.fullstackAngularSpring.repository.lancamento.LancamentoRepository;
import br.com.fullstackAngularSpring.repository.pessoa.PessoaRepository;
import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;
import br.com.fullstackAngularSpring.service.exceptions.PessoaInativaException;
import br.com.fullstackAngularSpring.service.lancamento.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository lacamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LancamentoMapper lancamentoMapper;

	@Override
	public LancamentoDto saveLancamento(LancamentoDto request) {
		Lancamento lancamento = lancamentoMapper.toEntity(request);
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getId()).get();
		if(pessoa.getFlagAtivo().equals(PessoaEnum.INATIVO.getValor())) {
			throw new PessoaInativaException("Pessoa: "+pessoa.getNome() +", de id: "+ pessoa.getId()+" está com situação de ativação: "+pessoa.getFlagAtivo());
		}
		lancamento.setPessoa(pessoa);
		Categoria categoria = categoriaRepository.findById(lancamento.getCategoria().getId()).get();
		lancamento.setCategoria(categoria);
		LancamentoDto dto = lancamentoMapper.toDto(lacamentoRepository.save(lancamento));
		return dto;
	}

	@Override
	public List<LancamentoDto> findAll() {
		return lancamentoMapper.toDto(lacamentoRepository.findAll());
	}

	@Override
	public List<LancamentoDto> findByPessoa(Long id) {
		List<LancamentoDto> listaDto = lancamentoMapper.toDto(lacamentoRepository.findByPessoaId(id));
		return listaDto;
	}

	@Override
	public void deleteLancamentoId(Long id) {
		lacamentoRepository.deleteById(id);		
	}

}
