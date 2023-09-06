package br.com.jjw.papelaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.domain.ItemCarrinho;
import br.com.jjw.papelaria.dto.dtoCarrinhoCompras;
import br.com.jjw.papelaria.dto.imprimirCarrinhoCompras;

@Service
public interface ItemCarrinhoService {
    List<imprimirCarrinhoCompras> listaItemCarrinhos();

    CarrinhoCompras adicionarItem(Long carrinhoId, dtoCarrinhoCompras itemCarrinho);

    void atualizar(ItemCarrinho itemCarrinhoAntigo, dtoCarrinhoCompras itemCarrinho);

    ItemCarrinho buscarPorId(long id);

    void deletar(Long idItemCarrinho);


}
