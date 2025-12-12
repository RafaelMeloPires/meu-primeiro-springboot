package com.example.meu_primeiro_springboot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Usando Jpa para mapear a classe Produto para relacionar com o banco de dados

//@Entity indica que a classe é uma entidade JPA
@Entity
//@Table especifica o nome da tabela no banco de dados
@Table(name = "produtos")
public class Produto {
    
    //@Id indica que o campo é a chave primária da tabela
    @Id
    //@GeneratedValue especifica a estratégia de geração do valor da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    public Produto() {}

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Double getPreco() {
        return preco;
    }

}
