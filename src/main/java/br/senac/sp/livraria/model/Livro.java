package br.senac.sp.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_livros")
@Data // LOMBOK: Cria automaticamente todos os Getters, Setters, toString, equals e hashCode
@NoArgsConstructor // LOMBOK: Cria o construtor vazio obrigatório para o funcionamento do Hibernate
@AllArgsConstructor // LOMBOK: Cria o construtor completo com todos os parâmetros do modelo
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // VALIDAÇÃO: Garante que o campo não seja enviado como nulo ou vazio
    @NotBlank(message = "O título do livro é obrigatório.")
    @Column(nullable = false)
    private String titulo;

    // VALIDAÇÃO: Torna obrigatório o envio do nome do autor
    @NotBlank(message = "O nome do autor é obrigatório.")
    @Column(nullable = false)
    private String autor;

    // VALIDAÇÃO: Torna obrigatório o envio do nome da editora
    @NotBlank(message = "A editora é obrigatória.")
    @Column(nullable = false)
    private String editora;

    // VALIDAÇÃO: Garante que o valor não seja nulo e seja maior que zero
    @NotNull(message = "O preço deve ser informado.")
    @Positive(message = "O preço deve ser um valor maior que zero.")
    @Column(nullable = false)
    private Double preco;

    // VALIDAÇÃO: Torna obrigatório o envio do ano do livro
    @NotNull(message = "O ano de edição deve ser informado.")
    @SuppressWarnings("SpellCheckingInspection") // INTELLIJ: Desativa o alerta visual de erro ortográfico na palavra 'edicao'
    @Column(name = "ano_edicao", nullable = false)
    private Integer anoEdicao;
}
