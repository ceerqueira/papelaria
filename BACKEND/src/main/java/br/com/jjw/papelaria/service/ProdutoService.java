package br.com.jjw.papelaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.Produto;

@Service
public interface ProdutoService {
    Produto cadastrarProduto(Produto produto);

    List<Produto> listar();

    Produto buscarPorId(long id);

    void atualizar(Produto produtoAntigo, Produto produtonovo);

    void deletar(long id);
}
