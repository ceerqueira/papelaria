package br.com.jjw.papelaria;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.jjw.papelaria.controller.ItemCarrinhoController;
import br.com.jjw.papelaria.domain.CarrinhoCompras;
import br.com.jjw.papelaria.domain.ItemCarrinho;
import br.com.jjw.papelaria.dto.imprimirCarrinhoCompras;
import br.com.jjw.papelaria.service.ItemCarrinhoService;

public class ItemCarrinhoControllerTest {

    @Mock
    private ItemCarrinhoService service;

    @InjectMocks
    private ItemCarrinhoController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAdicionarItemCarrinho() throws Exception {
        // Simule a entrada do cliente
        String requestBody = "{\"idCarrinhoCompras\": 1, \"outroCampo\": \"valor\"}";

        // Crie um objeto CarrinhoCompras para simular a resposta do serviço
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        // Defina o comportamento esperado para o serviço
        when(service.adicionarItem(anyLong(), any())).thenReturn(carrinhoCompras);

        mockMvc.perform(post("/adicionar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Pedido gravado com sucesso"));
    }

    @Test
    public void testListar() throws Exception {
        // Crie uma lista de imprimirCarrinhoCompras para simular a resposta do serviço
        List<imprimirCarrinhoCompras> lista = new ArrayList<>();
        // Defina o comportamento esperado para o serviço
        when(service.listaItemCarrinhos()).thenReturn(lista);

        mockMvc.perform(get("/adicionar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testAtualiza() throws Exception {
        // Simule a entrada do cliente
        String requestBody = "{\"idItemCarrinho\": 1, \"outroCampo\": \"valor\"}";

        // Crie um objeto ItemCarrinho para simular a resposta do serviço
        ItemCarrinho itemCarrinho = new ItemCarrinho();
        // Defina o comportamento esperado para o serviço
        when(service.buscarPorId(anyLong())).thenReturn(itemCarrinho);

        mockMvc.perform(put("/adicionar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletar() throws Exception {
        // Simule a entrada do cliente
        String requestBody = "{\"idItemCarrinho\": 1}";

        mockMvc.perform(delete("/adicionar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }
}