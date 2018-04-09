package br.com.fullstackAngularSpring.service.impl.categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullstackAngularSpring.builders.CategoriaBuilderEntity;
import br.com.fullstackAngularSpring.builders.CategoriaResponseBuilder;
import br.com.fullstackAngularSpring.model.categoria.Categoria;
import br.com.fullstackAngularSpring.repository.categoria.CategoriaRepository;
import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponse;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponseList;
import br.com.fullstackAngularSpring.service.categoria.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public CategoriaResponseList getAll() {
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
		Categoria categoria = categoriaRepository.findById(id).get();
		CategoriaResponseBuilder buildResponse = CategoriaResponseBuilder.create()
				.id(categoria.getId())
				.nomeCategoria(categoria.getNomeCategoria());		
		return buildResponse.build();
	}
	@Override
	public CategoriaResponse create(CategoriaRequest requeste) {
		CategoriaBuilderEntity builderEntity = CategoriaBuilderEntity.create()
				.name(requeste.getNomeCategoria());
		Categoria categoria = categoriaRepository.save(builderEntity.build());
		CategoriaResponseBuilder buildResponse = CategoriaResponseBuilder.create()
				.id(categoria.getId())
				.nomeCategoria(categoria.getNomeCategoria());		
		return buildResponse.build();
	}

}
