package br.com.avaliacao.restapi.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacao.restapi.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long categoriaId);
    
}
