package com.example.meu_primeiro_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Metodo para listar todos os produtos, que ja esta definido no JpaRepository
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }   

    //findById ja esta definido no JpaRepository
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    //save ja esta definido no JpaRepository
    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }    

    //deleteById ja esta definido no JpaRepository
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
