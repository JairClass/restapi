package br.com.avaliacao.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacao.restapi.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
