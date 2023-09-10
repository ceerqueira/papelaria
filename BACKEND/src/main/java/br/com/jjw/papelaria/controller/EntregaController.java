package br.com.jjw.papelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jjw.papelaria.model.Entrega;
import br.com.jjw.papelaria.model.dto.EntregaDTO;
import br.com.jjw.papelaria.service.EntregaService;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "http://localhost:3000")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @PostMapping
    public ResponseEntity<String >cadastrarEndereco(@RequestBody EntregaDTO entrega){
        Entrega endereco = service.cadastrar(entrega);
        return ResponseEntity.ok().body("Pedido cadastrado com sucesso\nSeu codigo de acesso é "+endereco.getNumeroPedido());

    }

    @GetMapping ("/{id}")
    public ResponseEntity<Entrega> listarPorId ( @PathVariable ("id")int id){
        Entrega endereco = service.buscarPorCodigo(id);
        return ResponseEntity.ok().body(endereco);

    }
    
}
