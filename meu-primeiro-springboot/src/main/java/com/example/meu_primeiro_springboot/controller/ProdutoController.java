package com.example.meu_primeiro_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController tem a funcionalidade de controlar as requisições feitas para a API
@RestController
//@RequestMapping define o caminho base para as requisições
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    //@GetMapping indica que esse método responde a requisições HTTP GET
    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();

    }

    //@GetMapping indica que esse método responde a requisições HTTP GET
    @GetMapping("/{id}")
    //ResponseEntity é uma classe que representa toda a resposta HTTP, incluindo status, cabeçalhos e corpo
    public ResponseEntity buscarProduto(@PathVariable Long id){ 
        //Esse método tenta buscar um produto pelo ID fornecido.
        //  Se encontrado, retorna o produto com status 200 OK; caso contrário, retorna 404 Not Found.
        return produtoService.buscarProdutoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    } 
}

