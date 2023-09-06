package br.com.jjw.papelaria;

import br.com.jjw.papelaria.controller.ProdutoController;
import br.com.jjw.papelaria.domain.Produto;
import br.com.jjw.papelaria.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;


class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarDepoimento() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto de Teste");

        when(produtoService.cadastrarProduto(any(Produto.class))).thenReturn(produto);

        ResponseEntity<Produto> response = produtoController.criarDepoimento(produto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produto, response.getBody());
        verify(produtoService, times(1)).cadastrarProduto(any(Produto.class));
    }

    @Test
    void testListar() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto());
        produtos.add(new Produto());

        when(produtoService.listar()).thenReturn(produtos);

        List<Produto> response = produtoController.listar();

        assertEquals(produtos, response);
        verify(produtoService, times(1)).listar();
    }

    @Test
    void testAtualiza() {
        Produto produtoAntigo = new Produto();
        produtoAntigo.setId(1L);
        produtoAntigo.setNome("Produto Antigo");

        Produto produtoNovo = new Produto();
        produtoNovo.setId(1L);
        produtoNovo.setNome("Produto Novo");

        // Simule o comportamento do método buscarPorId
        when(produtoService.buscarPorId(1L)).thenReturn(produtoAntigo);

        // Simule o comportamento do método atualizar (que é void)
        doNothing().when(produtoService).atualizar(produtoAntigo, produtoNovo);

        ResponseEntity<Produto> response = produtoController.atualiza(produtoNovo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtoNovo, response.getBody());
        verify(produtoService, times(1)).buscarPorId(1L);
        verify(produtoService, times(1)).atualizar(produtoAntigo, produtoNovo);
    }

    @Test
    void testDeletar() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto de Teste");

        ResponseEntity<Produto> response = produtoController.deletar(produto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produto, response.getBody());
        verify(produtoService, times(1)).deletar(1L);
    }
}
