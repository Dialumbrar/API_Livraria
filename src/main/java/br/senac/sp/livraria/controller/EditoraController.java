package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/editoras")
public class EditoraController {

    private final LivroService livroService;

    public EditoraController(LivroService livroService) {
        this.livroService = livroService;
    }

    // Retorna dinamicamente a lista real em formato JSON obtida pelo Service
    @GetMapping
    public ResponseEntity<List<String>> listarEditoras(){
        return ResponseEntity.ok(livroService.listarEditorasUnicas());
    }
}
