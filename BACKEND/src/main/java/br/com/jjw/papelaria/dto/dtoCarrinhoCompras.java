package br.com.jjw.papelaria.dto;

public record dtoCarrinhoCompras(
        Long idCarrinhoCompras,
        Long idProduto,
        int quantidade,
        Long idItemCarrinho) {

}
