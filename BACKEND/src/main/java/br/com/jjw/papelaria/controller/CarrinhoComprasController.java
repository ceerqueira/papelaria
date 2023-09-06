package br.com.jjw.papelaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.service.CarrinhoComprasService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/compras")
public class CarrinhoComprasController {

    @Autowired
    CarrinhoComprasService service;

    @PostMapping
    @Transactional
    public ResponseEntity<CarrinhoCompras> criarCarrinho(@RequestBody CarrinhoCompras dados) {
        CarrinhoCompras carrinho = service.criarCarrinhoCompras(dados);
        if (carrinho != null) {
            return ResponseEntity.ok().body(carrinho);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping
    public List<CarrinhoCompras> listar() {
        return service.listar();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CarrinhoCompras> atualiza(@RequestBody CarrinhoCompras carrinhoComprasNovo) {
        var carrinhoComprasAntigo = service.buscarPorId(carrinhoComprasNovo.getId());
        if (carrinhoComprasAntigo != null) {
            service.atualizar((CarrinhoCompras) carrinhoComprasAntigo, carrinhoComprasNovo);
            return ResponseEntity.ok().body(carrinhoComprasNovo);
        }
        return ResponseEntity.unprocessableEntity().build();

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<CarrinhoCompras> deletar(@RequestBody Long carrinhoId) {
        service.deletar(carrinhoId);
        return ResponseEntity.ok().body(null);
    }


}
