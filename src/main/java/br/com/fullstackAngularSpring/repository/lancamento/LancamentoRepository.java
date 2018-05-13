package br.com.fullstackAngularSpring.repository.lancamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.lancamento.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
