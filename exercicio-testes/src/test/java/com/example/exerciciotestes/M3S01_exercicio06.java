package com.example.exerciciotestes;

import com.example.exerciciotestes.controller.request.ClienteRequest;
import com.example.exerciciotestes.controller.request.ProdutoRequest;
import com.example.exerciciotestes.repository.ClienteRepository;
import com.example.exerciciotestes.repository.ProdutoRepository;
import com.example.exerciciotestes.service.ClienteService;
import com.example.exerciciotestes.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class M3S01_exercicio06 {

    //Crie os testes unitários para os métodos salvarProduto já existentes na classe ProdutoService
    @Test
    @DisplayName("Deve salvar um produto")
    public void salvarCliente() {
        // Cria um objeto ProdutoService e o objeto Producorequest mockado
        ProdutoService produtoService = new ProdutoService(mock(ProdutoRepository.class));
        ProdutoRequest produtoRequest = mock(ProdutoRequest.class);

        //atribui valores ao objeto mock
        when(produtoRequest.getNomeProduto()).thenReturn("aa");
        when(produtoRequest.getValorProduto()).thenReturn(10.0);

        //salvar produto
        produtoService.salvarProduto(produtoRequest);

        // Verifique se o comportamento esperado ocorreu usando o Mockito
        Assertions.assertEquals("aa", produtoRequest.getNomeProduto());

    }
}
