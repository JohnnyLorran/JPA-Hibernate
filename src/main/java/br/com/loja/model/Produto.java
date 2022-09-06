package br.com.loja.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//Anotação dizendo que essa classe é uma entity
//Entity é uma tabela do banco de dados
@Entity
//Anotação para dizer que o nome da table é "produtos", por padrão ele pega o nome da classe.
@Table(name = "produtos")
public class Produto {

        //Anotação é para dizer que o id é a chave primaria
        @Id
        //Anotação para dizer que o ID é gerado pelo banco e não pelo código
        // H2 não tem o type sequence.
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long id;
        private String nome;
        //Anotação para criar o nome do campo no banco de dados em vez de ser o nome do atributo
        //@Column(name = "desc")
        private String descricao;
        private BigDecimal preco;
        private LocalDate dataCadastro = LocalDate.now();
        //Anotação para dizer que vamos utilizar a String que está dentro do Enum e não a posição dela
        @ManyToOne
        private Categoria categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco,Categoria categoria){
            this.nome = nome;
            this.descricao = descricao;
            this.preco = preco;
            this.categoria = categoria;
        }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria= categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
