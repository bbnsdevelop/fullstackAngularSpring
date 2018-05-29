package br.com.fullstackAngularSpring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Query("select l from Lancamento l where l.pessoa.id =?1")
	Page<Lancamento> findByPessoaId(Long id, Pageable page);

}
