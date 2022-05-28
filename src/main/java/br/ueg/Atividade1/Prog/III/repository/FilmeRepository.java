package br.ueg.Atividade1.Prog.III.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ueg.Atividade1.Prog.III.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	List<Filme> findByDiretor(String diretor);
	
	Filme findByTitulo(String titulo);
	
	//metodo de busca em JPQL
	@Query("" +
            "SELECT CASE WHEN COUNT(f) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Filme f " +
            "WHERE f.titulo = ?1"
    )
    Boolean existeTitulo(String titulo);
}
