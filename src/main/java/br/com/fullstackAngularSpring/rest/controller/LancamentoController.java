package br.com.fullstackAngularSpring.rest.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;
import br.com.fullstackAngularSpring.rest.resource.LancamentoResource;
import br.com.fullstackAngularSpring.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController implements LancamentoResource{

	@Autowired
	LancamentoService lancamentoService;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaLancamentoPorid(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findByLancamentoId(id));
	}

	@Override
	@GetMapping()
	public ResponseEntity<?> buscaLancamentos() {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findAll());
	}

	@Override
	@PostMapping()
	public ResponseEntity<?> salvarLancamento(@Valid @RequestBody LancamentoDto request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.saveLancamento(request));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarLancamento(@PathVariable("id") Long id) {
		lancamentoService.deleteLancamentoId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	@GetMapping("pessoa/{id}")
	public ResponseEntity<?> buscaLancamentosPaginacao(@PathVariable("id") Long id, Pageable page) {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findLancamentosByPessoaId(id, page));
	}
	
	@Override
	@GetMapping("pessoa/{id}/{dataVencimentoInicio}/{dataVencimentoFim}")
	public ResponseEntity<?> buscaLancamentosPaginacaoDataVenimento(@PathVariable("id") Long id, 
																	@PathVariable("dataVencimentoInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataVencimentoInicio, 
																	@PathVariable("dataVencimentoFim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataVencimentoFim, Pageable page) {
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findLancamentosByPessoaIdAndDataVencimento(id, dataVencimentoInicio, dataVencimentoFim,  page));
	}


}
