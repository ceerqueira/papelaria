package br.com.jjw.papelaria.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.jjw.papelaria.exception.PapelariaException;
import br.com.jjw.papelaria.model.Entrega;
import br.com.jjw.papelaria.model.Pedido;
import br.com.jjw.papelaria.model.dto.EntregaDTO;
import br.com.jjw.papelaria.repository.EntregaRepository;
import br.com.jjw.papelaria.repository.PedidoRepository;
import br.com.jjw.papelaria.service.EntregaService;
import br.com.jjw.papelaria.util.ConstantesUtils;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private EntregaRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Entrega cadastrar(EntregaDTO entrega) {
        validarEntrega(entrega);

        gerarNumeroPedido(entrega);

        Entrega itemNovo = Entrega.builder()
                .endereco(entrega.getEndereco())
                .telefone(entrega.getTelefone())
                .numeroPedido(entrega.getNumeroPedido())
                .nome(entrega.getNome())
                .build();

        List<Pedido> pedidos = pedidoRepository.findByNumeroPedidoIsNull();
        for (Pedido item : pedidos) {
            item.setStatus(ConstantesUtils.CONCLUIDO);
            item.setNumeroPedido(entrega.getNumeroPedido());
        }

        return repository.save(itemNovo);
    }

    private void validarEntrega(EntregaDTO entrega) {
        if (entrega.getEndereco() == null) {
            throw new PapelariaException("Adicione um endereço");
        }
        if (entrega.getNome() == null) {
            throw new PapelariaException("Adicione um nome");
        }
        if (entrega.getTelefone() == null) {
            throw new PapelariaException("Adicione um telefone");
        }
    }

    private void gerarNumeroPedido(EntregaDTO entrega) {

        Random random = new Random();
        int verificaSeJaExiste = random.nextInt(10_000);
        while (repository.existsByNumeroPedido(verificaSeJaExiste)) {
            verificaSeJaExiste = random.nextInt(10_000);
        }
        int numero_pedido = random.nextInt(10_000); // gera um numero randomico de 4 digitos
        entrega.setNumeroPedido(numero_pedido);

    }

    @Override
    public Entrega buscarPorCodigo(int id) {
        return repository.findByNumeroPedido(id).orElseThrow( () -> new PapelariaException("Id não encontrado"));
    }

}
