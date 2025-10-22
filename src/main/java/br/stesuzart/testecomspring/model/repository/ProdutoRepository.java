package br.stesuzart.testecomspring.model.repository;

import br.stesuzart.testecomspring.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}