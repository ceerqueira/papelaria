package br.com.jjw.papelaria.dto;

import java.util.List;

import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.domain.Produto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class imprimirCarrinhoCompras {
    private int idItemCarrinho;
    private CarrinhoCompras carrinhoCompras;
    private List<Produto> produtos;
    
}
