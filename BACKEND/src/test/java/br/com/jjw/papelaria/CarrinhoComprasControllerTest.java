package br.com.jjw.papelaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.jjw.papelaria.controller.CarrinhoComprasController;
import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.service.CarrinhoComprasService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class CarrinhoComprasControllerTest {

    @InjectMocks
    private CarrinhoComprasController controller;

    @Mock
    private CarrinhoComprasService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarCarrinhoCompras() {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        when(service.criarCarrinhoCompras(carrinho)).thenReturn(carrinho);

        ResponseEntity<CarrinhoCompras> response = controller.criarCarrinho(carrinho);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(carrinho);
    }

    @Test
    public void testListarCarrinhosCompras() {
        List<CarrinhoCompras> carrinhos = new ArrayList<>();
        when(service.listar()).thenReturn(carrinhos);

        List<CarrinhoCompras> response = controller.listar();
        assertThat(response).isEqualTo(carrinhos);
    }

    @Test
    public void testAtualizarCarrinhoCompras() {
        CarrinhoCompras carrinhoAntigo = new CarrinhoCompras();
        CarrinhoCompras carrinhoNovo = new CarrinhoCompras();
        carrinhoNovo.setId(1L); // Defina uma ID válida para carrinhoNovo
    
        when(service.buscarPorId(carrinhoNovo.getId())).thenReturn(carrinhoAntigo);
        doNothing().when(service).atualizar(eq(carrinhoAntigo), eq(carrinhoNovo));
    
        ResponseEntity<CarrinhoCompras> response = controller.atualiza(carrinhoNovo);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(carrinhoNovo);
    }
    

    @Test
    public void testDeletarCarrinhoCompras() {
        long carrinhoId = 1L;
        ResponseEntity<CarrinhoCompras> response = controller.deletar(carrinhoId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
