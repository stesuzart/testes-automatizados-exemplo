package br.stesuzart.testecomspring.controller;

import br.stesuzart.testecomspring.entity.Produto;
import br.stesuzart.testecomspring.service.ProdutoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
    private ProdutoService produtoService;
    public ProdutoController(ProdutoService productService) {
        this.produtoService = productService;
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto product) {
        Produto produtoSalvo = produtoService.adicionarProduto(product);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return new ResponseEntity<>(produtoService.listarProdutos(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id){
        return new ResponseEntity<>(produtoService.buscarProdutoPorId(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> removerProduto(@PathVariable("id") Long id) {
        Produto produto = produtoService.removerProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}