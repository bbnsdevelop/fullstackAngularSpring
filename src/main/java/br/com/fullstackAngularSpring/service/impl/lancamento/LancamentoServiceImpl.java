package br.com.fullstackAngularSpring.service.impl.lancamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.mapper.LancamentoMapper;
import br.com.fullstackAngularSpring.model.lancamento.Lancamento;
import br.com.fullstackAngularSpring.repository.lancamento.LancamentoRepository;
import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;
import br.com.fullstackAngularSpring.service.lancamento.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository lacamentoRepository;
	
	@Autowired
	private LancamentoMapper lancamentoMapper;

	@Override
	public LancamentoDto saveLancamento(LancamentoDto request) {
		Lancamento lancamento = lancamentoMapper.toEntity(request);
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

}
