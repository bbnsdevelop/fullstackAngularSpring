package br.com.fullstackAngularSpring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.resource.PessoaResource;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;
import br.com.fullstackAngularSpring.service.pessoa.PessoaService;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController implements PessoaResource{
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	@PostMapping
	public ResponseEntity<?> cadastroPessoa(@Validated @RequestBody PessoaRequest pessoa) {
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.criar(pessoa));
	}

	@Override
	public ResponseEntity<?> atualizaPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deletaPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<PessoaResponse>> buscaTodasPessoas() {		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAll());
	}
	
	
	/*
	 
	 INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
	   	values (1, 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', 'S');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (11, 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (12, 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (13, 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', 'S');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (14, 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (15, 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (16, 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (17, 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (18, 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', 'N');
INSERT INTO endereco (pessoa_id, logradouro, numero, complemento, bairro, cep, cidade, estado, flag_ende_princ) 
		values (17, 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', 'S');
	 
	 */

}
