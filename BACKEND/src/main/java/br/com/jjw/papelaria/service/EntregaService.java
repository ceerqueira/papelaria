package br.com.jjw.papelaria.service;

import br.com.jjw.papelaria.model.Entrega;
import br.com.jjw.papelaria.model.dto.EntregaDTO;

public interface EntregaService {
    public Entrega cadastrar(EntregaDTO entrega);

    public Entrega buscarPorCodigo(int id);
}
