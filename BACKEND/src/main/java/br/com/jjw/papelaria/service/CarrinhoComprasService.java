package br.com.jjw.papelaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.CarrinhoCompras;


@Service
public interface CarrinhoComprasService {

    CarrinhoCompras criarCarrinhoCompras(CarrinhoCompras carrinhoCompras);

    List<CarrinhoCompras> listar();

    CarrinhoCompras buscarPorId(long id);

    void atualizar(CarrinhoCompras carrinhoComprasAntigo, CarrinhoCompras carrinhoComprasAntigoNovo);

    void deletar(Long id);


}
