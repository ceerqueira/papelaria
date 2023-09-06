package br.com.jjw.papelaria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.Produto;
import br.com.jjw.papelaria.exception.IdProdutoNotFound;
import br.com.jjw.papelaria.exception.ProdutoNotFoundException;
import br.com.jjw.papelaria.repository.ProdutoRepository;
import br.com.jjw.papelaria.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto cadastrarProduto(Produto produto) {
        if(produto.getNome() == null){
            throw new ProdutoNotFoundException("É necessario colocar um nome ");
        }
        if(produto.getDescricao() == null){
            throw new ProdutoNotFoundException("É necessario colocar uma descrição para o prodotuo");
        }
        if(produto.getPreco() == null){
            throw new ProdutoNotFoundException("É necessario colocar o preço do produto");
        }
        if(produto.getQuantidade()== 0){
            throw new ProdutoNotFoundException("É necessario colocar a quantidade do produto");
        }
        return repository.save(produto);
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll();
    }

    @Override
    public Produto buscarPorId(long id) {
        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new IdProdutoNotFound("Produto com ID " + id + " não encontrado.");
        }
    }



    @Override
    public void atualizar(Produto produtoantigo, Produto produtonovo) {

        if (produtonovo.getNome() != null) {
            produtoantigo.setNome(produtonovo.getNome());
        }
        if (produtonovo.getDescricao() != null) {
            produtoantigo.setDescricao(produtonovo.getDescricao());
        }
        if (produtonovo.getPreco() != null) {
            produtoantigo.setPreco(produtonovo.getPreco());
        }
        if (produtonovo.getQuantidade() != 0) {
            produtoantigo.setQuantidade(produtonovo.getQuantidade());
        }

    }

    @Override
    public void deletar(long id) {
        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IdProdutoNotFound("Produto com ID " + id + " não encontrado.");
        }
        
    }

}
