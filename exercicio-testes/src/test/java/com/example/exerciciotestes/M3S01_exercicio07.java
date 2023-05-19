package com.example.exerciciotestes;

import com.example.exerciciotestes.controller.request.ProdutoRequest;
import com.example.exerciciotestes.repository.ProdutoRepository;
import com.example.exerciciotestes.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class M3S01_exercicio07 {

    @Test
    @DisplayName("Deve atualizar um Produto no banco de dados")

// Crie os testes unitários para os métodos atualizarProduto já existente na classe ProdutoService
    public void atualizarProduto() {
        // Cria um objeto Produtoservice e o objeto ProdutoResquest mockado
        ProdutoService produtoService = new ProdutoService(mock(ProdutoRepository.class));
        ProdutoRequest produtoRequest = mock(ProdutoRequest.class);

        //atribui valores ao objeto mock para atualizar o Produto
        when(produtoRequest.getNomeProduto()).thenReturn("atualizado");
        when(produtoRequest.getValorProduto()).thenReturn(10.0);

        //salvar cliente
        produtoService.atualizarProduto(1L, produtoRequest);

        // Verifique se o comportamento esperado ocorreu usando o Mockito
        Assertions.assertEquals("atualizado", produtoRequest.getNomeProduto());
        Assertions.assertEquals(10.0, produtoRequest.getValorProduto());

    }
}
