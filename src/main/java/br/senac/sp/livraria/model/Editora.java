package br.senac.sp.livraria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_editoras")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private String cnpj;

    private String cidade;

    private String site;

    // Evita loop infinito na serialização JSON entre Editora e Livro
    @OneToMany(mappedBy = "editora")
    @JsonIgnore
    private List<Livro> livros;

    public Editora() {
    }

    public Editora(Integer id, String nome, String cnpj, String cidade, String site) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.site = site;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}