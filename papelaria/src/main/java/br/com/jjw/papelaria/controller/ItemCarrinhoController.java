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
import br.com.jjw.papelaria.domain.ItemCarrinho;
import br.com.jjw.papelaria.dto.dtoCarrinhoCompras;
import br.com.jjw.papelaria.dto.imprimirCarrinhoCompras;
import br.com.jjw.papelaria.service.ItemCarrinhoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/adicionar")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> adicionarItemCarrinho(@RequestBody dtoCarrinhoCompras itemCarrinho) {
        CarrinhoCompras item = service.adicionarItem(itemCarrinho.idCarrinhoCompras(), itemCarrinho);
        if (item != null) {
            return ResponseEntity.ok().body("Pedido gravado com sucesso");
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping
    public List<imprimirCarrinhoCompras> listar() {
        return service.listaItemCarrinhos();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemCarrinho> atualiza(@RequestBody dtoCarrinhoCompras itemCarrinhoNovo) {
        ItemCarrinho itemCarrinhoAntigo = service.buscarPorId(itemCarrinhoNovo.idItemCarrinho());
        if (itemCarrinhoAntigo != null) {
            service.atualizar((ItemCarrinho) itemCarrinhoAntigo, itemCarrinhoNovo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.unprocessableEntity().build();

    }
    @DeleteMapping
    @Transactional
    public ResponseEntity<ItemCarrinho> deletar(@RequestBody dtoCarrinhoCompras dados) {
        service.deletar(dados.idItemCarrinho());
        return ResponseEntity.ok().body(null);
    }


}
