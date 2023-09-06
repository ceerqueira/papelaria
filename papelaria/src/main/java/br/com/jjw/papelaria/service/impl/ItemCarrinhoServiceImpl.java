package br.com.jjw.papelaria.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.domain.ItemCarrinho;
import br.com.jjw.papelaria.domain.Produto;
import br.com.jjw.papelaria.dto.dtoCarrinhoCompras;
import br.com.jjw.papelaria.dto.imprimirCarrinhoCompras;
import br.com.jjw.papelaria.exception.ItemCarrinhosNotFoundException;
import br.com.jjw.papelaria.repository.CarrinhoComprasRepository;
import br.com.jjw.papelaria.repository.ItemCarrinhoRepository;
import br.com.jjw.papelaria.repository.ProdutoRepository;
import br.com.jjw.papelaria.service.ItemCarrinhoService;
import jakarta.transaction.Transactional;

@Service
public class ItemCarrinhoServiceImpl implements ItemCarrinhoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private CarrinhoComprasRepository carrinhoComprasRepository;

    @Override
    @Transactional
    public CarrinhoCompras adicionarItem(Long carrinhoId, dtoCarrinhoCompras itemCarrinho) {

        if (itemCarrinho.idCarrinhoCompras() == null) {
            throw new ItemCarrinhosNotFoundException("Adicionar id do Carrinho de compras");
        }
        if (itemCarrinho.idProduto() == null) {
            throw new ItemCarrinhosNotFoundException("Adicionar id do produto");
        }
        if (itemCarrinho.quantidade() == 0) {
            throw new ItemCarrinhosNotFoundException("Quantidade insuficiente");
        }
        // Obtenha o carrinho de compras existente
        CarrinhoCompras carrinho = carrinhoComprasRepository.findById(carrinhoId)
                .orElseThrow(() -> new ItemCarrinhosNotFoundException("Carrinho de compras não encontrado"));

        // Obtenha o produto que deseja adicionar ao carrinho
        Produto produto = produtoRepository.findById(itemCarrinho.idProduto())
                .orElseThrow(() -> new ItemCarrinhosNotFoundException("Produto não encontrado"));

        produto.setQuantidade(produto.getQuantidade() - itemCarrinho.quantidade());
        if (produto.getQuantidade() < 0) {
            throw new RuntimeException("Quantidade insuficiente");
        }

        // Crie um novo item de carrinho com base nos dados fornecidos
        ItemCarrinho novoItemCarrinho = new ItemCarrinho();
        novoItemCarrinho.setProduto(produto);
        novoItemCarrinho.setQuantidade(itemCarrinho.quantidade());
        novoItemCarrinho.setCarrinhoCompras(carrinho);

        // Adicione o novo item ao carrinho de compras
        itemCarrinhoRepository.save(novoItemCarrinho);

        // Atualize o carrinho no banco de dados
        carrinho = carrinhoComprasRepository.save(carrinho);

        return carrinho;
    }

    @Override
    public List<imprimirCarrinhoCompras> listaItemCarrinhos() {
        List<imprimirCarrinhoCompras> carrinhosInfo = new ArrayList<>();

        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findAll();

        Map<CarrinhoCompras, List<Produto>> carrinhoProdutoMap = new HashMap<>();

        for (ItemCarrinho item : itensCarrinho) {
            CarrinhoCompras carrinho = item.getCarrinhoCompras();
            Produto produto = item.getProduto();
            produto.setQuantidade(item.getQuantidade());

            if (!carrinhoProdutoMap.containsKey(carrinho)) {
                carrinhoProdutoMap.put(carrinho, new ArrayList<>());
            }

            carrinhoProdutoMap.get(carrinho).add(produto);
        }

        for (Map.Entry<CarrinhoCompras, List<Produto>> entry : carrinhoProdutoMap.entrySet()) {
            CarrinhoCompras carrinho = entry.getKey();
            List<Produto> produtos = entry.getValue();

            imprimirCarrinhoCompras carrinhoInfo = new imprimirCarrinhoCompras();
            carrinhoInfo.setCarrinhoCompras(carrinho);
            carrinhoInfo.setProdutos(produtos);

            carrinhosInfo.add(carrinhoInfo);
        }

        return carrinhosInfo;
    }

    @Override
    public void atualizar(ItemCarrinho itemCarrinhoAntigo, dtoCarrinhoCompras itemCarrinhoNovo) {

        if (itemCarrinhoNovo.idProduto() != null) {
            Produto produto = produtoRepository.getReferenceById(itemCarrinhoNovo.idProduto());
            itemCarrinhoAntigo.setProduto(produto);
        }
        if (itemCarrinhoNovo.idCarrinhoCompras() != null) {
            CarrinhoCompras carrinhoCompras = carrinhoComprasRepository
                    .getReferenceById(itemCarrinhoNovo.idCarrinhoCompras());
            itemCarrinhoAntigo.setCarrinhoCompras(carrinhoCompras);
        }
        if (itemCarrinhoNovo.quantidade() != 0) {
            itemCarrinhoAntigo.setQuantidade(itemCarrinhoNovo.quantidade());
        }

    }

    @Override
    public ItemCarrinho buscarPorId(long id) {

        Optional<ItemCarrinho> itemCarrinho = itemCarrinhoRepository.findById(id);

        if (itemCarrinho.isPresent()) {
            return itemCarrinho.get();
        } else {
            throw new ItemCarrinhosNotFoundException(
                    "Item para adicionar ao Carrinho com ID " + id + " não encontrado.");
        }
    }

    @Override
    public void deletar(Long idItemCarrinho) {

        Optional<ItemCarrinho> itemCarrinho = itemCarrinhoRepository.findById(idItemCarrinho);

        if (itemCarrinho.isPresent()) {
            itemCarrinhoRepository.deleteById(idItemCarrinho);
        } else {
            throw new ItemCarrinhosNotFoundException(
                    "Item para adicionar ao Carrinho com ID " + idItemCarrinho + " não encontrado.");
        }
    }
}
