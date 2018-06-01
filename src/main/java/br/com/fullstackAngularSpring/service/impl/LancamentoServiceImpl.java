package br.com.fullstackAngularSpring.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.enumerator.PessoaEnum;
import br.com.fullstackAngularSpring.mapper.LancamentoMapper;
import br.com.fullstackAngularSpring.model.Categoria;
import br.com.fullstackAngularSpring.model.Lancamento;
import br.com.fullstackAngularSpring.model.Pessoa;
import br.com.fullstackAngularSpring.repository.CategoriaRepository;
import br.com.fullstackAngularSpring.repository.LancamentoRepository;
import br.com.fullstackAngularSpring.repository.PessoaRepository;
import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;
import br.com.fullstackAngularSpring.service.LancamentoService;
import br.com.fullstackAngularSpring.service.exceptions.PessoaInativaException;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
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
		log.info("salvanto um lançamento");
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
		log.info("Buscando todos os lançamentos");
		return lancamentoMapper.toDto(lacamentoRepository.findAll());
	}

	@Override
	public LancamentoDto findByLancamentoId(Long id) {
		log.info("Buscando o lançamento por id: " + id);
		LancamentoDto listaDto = lancamentoMapper.toDto(lacamentoRepository.findById(id).get());
		return listaDto;
	}

	@Override
	public void deleteLancamentoId(Long id) {
		log.info("Deletando o lançamento por id: " + id);
		lacamentoRepository.deleteById(id);		
	}

	@Override
	public Page<LancamentoDto> findLancamentosByPessoaId(Long id, Pageable page) {
		log.info("Buscando o lançamento por id: " + id + " com paginação: " + page.getPageNumber());
		return lacamentoRepository.findByPessoaId(id, page).map(lancamentoMapper::toDto);
	}

	@Override
	public Page<LancamentoDto> findLancamentosByPessoaIdAndDataVencimento(Long id, LocalDate dataVencimentoInicio,
			LocalDate dataVencimentoFim, Pageable page) {
		log.info("Buscando o lançamento por id: " + id +"| Data inicio: "+dataVencimentoInicio + "| Data fim: "+dataVencimentoFim +"| com paginação: " + page.getPageNumber());
		return lacamentoRepository.findByPessoaDataVencimento(id, dataVencimentoInicio, dataVencimentoFim, page).map(lancamentoMapper::toDto);
	}


}
