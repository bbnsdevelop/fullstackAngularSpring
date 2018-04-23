package br.com.fullstackAngularSpring.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.pessoa.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query("select p from Pessoa p where p.cpf =:cpf")
	Pessoa findByCpf(@Param("cpf") String cpf);

}
