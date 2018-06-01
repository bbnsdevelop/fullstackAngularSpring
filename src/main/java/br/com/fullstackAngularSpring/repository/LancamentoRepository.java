package br.com.fullstackAngularSpring.repository;

import java.time.LocalDate;

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
	
	@Query("SELECT l FROM Lancamento l where l.pessoa.id =?1 AND l.dataVencimento BETWEEN ?2 AND ?3")
	Page<Lancamento> findByPessoaDataVencimento(Long id, LocalDate dataVencimentoInicio, LocalDate dataVencimentoFim, Pageable page);

}
