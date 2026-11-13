package br.senac.sp.livraria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Double preco;

    @SuppressWarnings("SpellCheckingInspection")
    @Column(name = "ano_edicao", nullable = false)
    private Integer anoEdicao;

    // Chaves estrangeiras mapeadas na tabela tb_livros
    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, Double preco, Integer anoEdicao, Editora editora, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.anoEdicao = anoEdicao;
        this.editora = editora;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(Integer anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}