package br.com.fullstackAngularSpring.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullstackAngularSpring.model.categoria.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
