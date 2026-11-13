package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Categoria;
import br.senac.sp.livraria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> atualizar(Long id, Categoria dadosAtualizados) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNome(dadosAtualizados.getNome());
            return categoriaRepository.save(categoria);
        });
    }

    public boolean deletar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}