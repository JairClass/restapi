package br.com.avaliacao.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.restapi.entity.Categoria;
import br.com.avaliacao.restapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
    private  CategoriaRepository CategoriaRepository;
 

    public List<Categoria> listarTodos() {
        return CategoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return CategoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria Categoria) {
        return CategoriaRepository.save(Categoria);
    }

    public void deletar(Long id) {
        CategoriaRepository.deleteById(id);
    }
}
