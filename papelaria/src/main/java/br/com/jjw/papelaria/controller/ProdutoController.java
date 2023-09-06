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

import br.com.jjw.papelaria.domain.Produto;
import br.com.jjw.papelaria.service.ProdutoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Produto> criarDepoimento(@RequestBody Produto dados) {
        Produto produto = service.cadastrarProduto(dados);
        if (produto != null) {
            return ResponseEntity.ok().body(produto);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Produto> atualiza(@RequestBody Produto produtoNovo) {
        Produto produtoAntigo = service.buscarPorId(produtoNovo.getId());

        if (produtoAntigo != null) {
            service.atualizar((Produto) produtoAntigo, produtoNovo);
           return ResponseEntity.ok().body(produtoNovo);
        }
        return ResponseEntity.unprocessableEntity().build();

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Produto> deletar(@RequestBody Produto dados) {
        service.deletar(dados.getId());
        return ResponseEntity.ok().body(dados);
    }

}
