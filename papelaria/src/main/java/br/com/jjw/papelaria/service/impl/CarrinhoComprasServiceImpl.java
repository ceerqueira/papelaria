package br.com.jjw.papelaria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.exception.CarrinhoComprasNotFoundException;
import br.com.jjw.papelaria.exception.ProdutoNotFoundException;
import br.com.jjw.papelaria.repository.CarrinhoComprasRepository;
import br.com.jjw.papelaria.service.CarrinhoComprasService;

@Service
public class CarrinhoComprasServiceImpl implements CarrinhoComprasService {

    @Autowired
    private CarrinhoComprasRepository carrinhoComprasRepository;

    @Override
    public CarrinhoCompras criarCarrinhoCompras(CarrinhoCompras carrinhoCompras) {
        if (carrinhoCompras.getEndereco().getEndereco() == null) {
            throw new CarrinhoComprasNotFoundException("É necessario colocar um endereço ");
        }
        if (carrinhoCompras.getEndereco().getNome() == null) {
            throw new CarrinhoComprasNotFoundException("É necessario colocar o nome do do cliente");
        }
        if (carrinhoCompras.getEndereco().getTelefone() == null) {
            throw new ProdutoNotFoundException("É necessario colocar o telefone do cliente");
        }

        return carrinhoComprasRepository.save(carrinhoCompras);
    }

    @Override
    public List<CarrinhoCompras> listar() {
        return carrinhoComprasRepository.findAll();
    }

    @Override
    public CarrinhoCompras buscarPorId(long id) {

        Optional<CarrinhoCompras> optionalProduto = carrinhoComprasRepository.findById(id);

        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new CarrinhoComprasNotFoundException("CarrinhoCompras com ID " + id + " não encontrado.");
        }

    }

    @Override
    public void atualizar(CarrinhoCompras carrinhoComprasAntigo, CarrinhoCompras carrinhoComprasNovo) {

        if (carrinhoComprasNovo.getEndereco().getNome() != null) {
            carrinhoComprasAntigo.getEndereco().setNome(carrinhoComprasNovo.getEndereco().getNome());
            ;
        }
        if (carrinhoComprasNovo.getEndereco().getEndereco() != null) {
            carrinhoComprasAntigo.getEndereco().setEndereco(carrinhoComprasNovo.getEndereco().getEndereco());
            ;
        }
        if (carrinhoComprasNovo.getEndereco().getTelefone() != null) {
            carrinhoComprasAntigo.getEndereco().setTelefone(carrinhoComprasNovo.getEndereco().getTelefone());
            ;
        }

    }

    @Override
    public void deletar(Long id) {

        Optional<CarrinhoCompras> optionalProduto = carrinhoComprasRepository.findById(id);

        if (optionalProduto.isPresent()) {
            carrinhoComprasRepository.deleteById(id);
        } else {
            throw new CarrinhoComprasNotFoundException("CarrinhoCompras com ID " + id + " não encontrado.");
        }
    }

}
