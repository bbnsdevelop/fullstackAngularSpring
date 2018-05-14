package br.com.fullstackAngularSpring.repository.lancamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.lancamento.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Query("select l from Lancamento l where l.pessoa.id =?1")
	List<Lancamento> findByPessoaId(Long id);

}
