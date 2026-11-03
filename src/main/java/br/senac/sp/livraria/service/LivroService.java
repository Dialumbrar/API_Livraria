package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(int id) {
        return livroRepository.findById(id);
    }

    // Busca todos os livros salvos e extrai os nomes das editoras sem repetição
    public List<String> listarEditorasUnicas() {
        return livroRepository.findAll()
                .stream()
                .map(Livro::getEditora) // Transforma a lista de Livro em lista de Strings (nomes das editoras)
                .distinct()             // Filtra e remove itens repetidos do resultado
                .collect(Collectors.toList());
    }
}
