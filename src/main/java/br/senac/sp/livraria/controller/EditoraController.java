package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.service.EditoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/editoras")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @PostMapping
    public ResponseEntity<Editora> salvar(@RequestBody Editora editora) {
        return ResponseEntity.status(201).body(editoraService.salvar(editora));
    }

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras() {
        return ResponseEntity.ok(editoraService.listarEditoras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable int id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/dominio")
    public ResponseEntity<List<Editora>> buscarPorDominio(@RequestParam String site) {
        return ResponseEntity.ok(editoraService.buscarPorDominio(site));
    }

    @GetMapping("/ordenadas")
    public ResponseEntity<List<Editora>> listarOrdenadas() {
        return ResponseEntity.ok(editoraService.listarOrdenadasPorNome());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> atualizar(@PathVariable int id, @RequestBody Editora editora) {
        return editoraService.atualizar(id, editora)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (editoraService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}