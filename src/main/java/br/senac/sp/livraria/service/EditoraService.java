package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    public List<Editora> listarEditoras() {
        return editoraRepository.findAll();
    }

    public Optional<Editora> buscarPorId(int id) {
        return editoraRepository.findById(id);
    }

    public List<Editora> buscarPorDominio(String dominio) {
        return editoraRepository.findBySiteContainingIgnoreCase(dominio);
    }

    public List<Editora> listarOrdenadasPorNome() {
        return editoraRepository.findAllByOrderByNomeAsc();
    }

    public Optional<Editora> atualizar(int id, Editora dadosAtualizados) {
        return editoraRepository.findById(id).map(editora -> {
            editora.setNome(dadosAtualizados.getNome());
            editora.setCnpj(dadosAtualizados.getCnpj());
            editora.setCidade(dadosAtualizados.getCidade());
            editora.setSite(dadosAtualizados.getSite());
            return editoraRepository.save(editora);
        });
    }

    public boolean deletar(int id) {
        if (editoraRepository.existsById(id)) {
            editoraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}