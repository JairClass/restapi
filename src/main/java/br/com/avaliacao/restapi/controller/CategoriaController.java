package br.com.avaliacao.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.restapi.entity.Categoria;
import br.com.avaliacao.restapi.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
    private  CategoriaService CategoriaService;

    @GetMapping
    public List<Categoria> listarTodos() {
        return CategoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return CategoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    
    @PostMapping
    public Categoria criar(@RequestBody Categoria Categoria) {
        return CategoriaService.salvar(Categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria Categoria) {
        return CategoriaService.buscarPorId(id)
                .map(p -> {
                    Categoria.setId(id);
                    return ResponseEntity.ok(CategoriaService.salvar(Categoria));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> atualizarParcial(@PathVariable Long id, @RequestBody Categoria parcial) {
        return CategoriaService.buscarPorId(id)
                .map(Categoria -> {
                    if (parcial.getNome() != null) Categoria.setNome(parcial.getNome());
                    return ResponseEntity.ok(CategoriaService.salvar(Categoria));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (CategoriaService.buscarPorId(id).isPresent()) {
            CategoriaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
