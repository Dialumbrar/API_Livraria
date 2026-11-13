package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    // @Valid: Intercepta a requisição POST para executar os filtros inseridos na Model
    @PostMapping
    public ResponseEntity<Livro> salvar(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return ResponseEntity.status(201).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    // Desativa o alerta visual de erro na palavra 'codigo'
    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping("/{codigo}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable("codigo") int id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
