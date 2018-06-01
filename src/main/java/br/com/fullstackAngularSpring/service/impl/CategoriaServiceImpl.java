package br.com.fullstackAngularSpring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.CategoriaBuilderEntity;
import br.com.fullstackAngularSpring.builders.CategoriaResponseBuilder;
import br.com.fullstackAngularSpring.exceptions.FindException;
import br.com.fullstackAngularSpring.model.Categoria;
import br.com.fullstackAngularSpring.repository.CategoriaRepository;
import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponse;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponseList;
import br.com.fullstackAngularSpring.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaResponseList getAll() {
		log.info("busca de todas as categorias");
		List<CategoriaResponse> listaCategorias = new ArrayList<>();
		categoriaRepository.findAll().stream().forEach(c ->{
			CategoriaResponseBuilder buildResponse = CategoriaResponseBuilder.create()
			.id(c.getId())
			.nomeCategoria(c.getNomeCategoria());
			listaCategorias.add(buildResponse.build());
		});
		CategoriaResponseList lista = new CategoriaResponseList();
		lista.setCategoriasResponse(listaCategorias);
		return lista;
	}
	@Override
	public CategoriaResponse getById(Long id) {
		log.info("busca de categoria por id:"+ id);
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(FindException::new);
		CategoriaResponseBuilder buildResponse = CategoriaResponseBuilder.create()
				.id(categoria.getId())
				.nomeCategoria(categoria.getNomeCategoria());		
		return buildResponse.build();
	}
	@Override
	public CategoriaResponse create(CategoriaRequest requeste) {
		log.info("Criando uma categoria");
		CategoriaBuilderEntity builderEntity = CategoriaBuilderEntity.create()
				.name(requeste.getNomeCategoria());
		Categoria categoria = categoriaRepository.save(builderEntity.build());
		CategoriaResponseBuilder buildResponse = CategoriaResponseBuilder.create()
				.id(categoria.getId())
				.nomeCategoria(categoria.getNomeCategoria());		
		return buildResponse.build();
	}
	
	/*
	
	// build
	
	 default  List<CorretagemCorretorDTO> toDtos(List<CorretagemCorretor> corretagemCorretores){
    	List<CorretagemCorretorDTO> CorretagemCorretoresDTO = new ArrayList<>();
    	
    	for (Iterator<?> it = corretagemCorretores.iterator(); it.hasNext(); ) {
			Object[] myResult = (Object[]) it.next();			
			
			Long id = (Long) myResult[0];
			Float valorPorcetagemCorretagem = (Float) myResult[1];
			String indentificadoProLabore = (String) myResult[2];
			LocalDate dataAlteracao = (LocalDate) myResult[3];
			String codigoControleVersao = (String) myResult[4];
			Long crtg = (Long) myResult[5];
			Long cort = (Long) myResult[6];
			String descricaoCorretor = (String) myResult[7];
			CorretagemCorretorDTO dto = new CorretagemCorretorDTO();
			dto.setId(id);
			dto.setValorPorcetagemCorretagem(valorPorcetagemCorretagem);
			dto.setIndentificadoProLabore(indentificadoProLabore);
			dto.setDataAlteracao(dataAlteracao);
			dto.setCodigoControleVersao(codigoControleVersao);
			dto.setCrtg(crtg);
			dto.setCort(cort);
			dto.setDescricaoCorretor(descricaoCorretor);
			CorretagemCorretoresDTO.add(dto);									
		}
		return CorretagemCorretoresDTO;
	}
	
	
	*/

}
