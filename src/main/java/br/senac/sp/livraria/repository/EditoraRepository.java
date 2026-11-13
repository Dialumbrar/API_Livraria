package br.senac.sp.livraria.repository;

import br.senac.sp.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer> {

    // Filtra editoras pelo trecho do domínio informado no site
    List<Editora> findBySiteContainingIgnoreCase(String dominio);

    List<Editora> findAllByOrderByNomeAsc();
}