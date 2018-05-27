package br.com.fullstackAngularSpring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.fullstackAngularSpring.mapper.entityMapper.EntityMapper;
import br.com.fullstackAngularSpring.model.Lancamento;
import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

@Mapper(componentModel = "spring")
public interface LancamentoMapper extends EntityMapper<LancamentoDto, Lancamento> {

	@Mapping(source = "categoria.id", target = "catelogoriaId")
	@Mapping(source = "pessoa.id", target = "pessoaId")
	LancamentoDto toDto(Lancamento lancamento);

	@Mapping(source = "catelogoriaId", target = "categoria.id")
	@Mapping(source = "pessoaId", target = "pessoa.id")
	Lancamento toEntity(LancamentoDto lancamentoDto);

	default Lancamento fromId(Long id) {
		if (id == null) {
			return null;
		}
		Lancamento lancamento = new Lancamento();
		lancamento.setId(id);
		return lancamento;
	}

}
