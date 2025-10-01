package br.stesuzart.testecomspring.service;

import br.stesuzart.testecomspring.entity.Produto;
import br.stesuzart.testecomspring.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (!optionalProduto.isPresent()) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        return optionalProduto.get();
    }

    public Produto removerProduto(Long id) {
        Produto produto = buscarProdutoPorId(id);
        produtoRepository.delete(produto);
        return produto;
    }
}