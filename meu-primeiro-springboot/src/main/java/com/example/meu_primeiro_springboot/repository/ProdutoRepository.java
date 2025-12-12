package com.example.meu_primeiro_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.meu_primeiro_springboot.model.Produto;

//@Repository indica que a interface é um repositório Spring Data
@Repository

//interface para operações de CRUD na entidade Produto
//Na classe JpaRepository, ja estao definidos os principais metodos para CRUD
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    

}
