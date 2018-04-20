package br.com.fullstackAngularSpring.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.pessoa.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
