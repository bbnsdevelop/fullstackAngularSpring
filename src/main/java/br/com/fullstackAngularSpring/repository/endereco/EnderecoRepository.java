package br.com.fullstackAngularSpring.repository.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.endereco.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
