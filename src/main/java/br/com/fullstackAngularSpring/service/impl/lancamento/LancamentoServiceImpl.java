package br.com.fullstackAngularSpring.service.impl.lancamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fullstackAngularSpring.repository.lancamento.LancamentoRepository;
import br.com.fullstackAngularSpring.rest.request.LancamentoRequest;
import br.com.fullstackAngularSpring.rest.response.LancamentoResponse;
import br.com.fullstackAngularSpring.service.lancamento.LancamentoService;

public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository lacamentoRepository;

	@Override
	public LancamentoResponse saveLancamento(Long pessoaId, Long catId, LancamentoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LancamentoResponse> findAll() {
		lacamentoRepository.findAll();
		return null;
	}

	@Override
	public List<LancamentoResponse> findByPessoa(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
