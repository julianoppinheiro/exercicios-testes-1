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
class M3S01_exercicio08 {

    //Crie os testes unitários para os métodos detelarProdutoPorId já existente na classe ProdutoService

    @Test
    @DisplayName("Deve deletar um Produto na base de dados")
    void deletarProdutoPorId() {
        // Cria um objeto ProdutoService e o objeto ProdutoResquest mockado
        ProdutoService ProdutoService = new ProdutoService(mock(ProdutoRepository.class));
        ProdutoRequest produtoRequest = mock(ProdutoRequest.class);

        //atribui valores ao objeto mock para deletar o Produto
        when(produtoRequest.getNomeProduto()).thenReturn("deletado");
        when(produtoRequest.getValorProduto()).thenReturn(10.0);

        //salvar Produto
        ProdutoService.salvarProduto(produtoRequest);

        //deletar Produto
        ProdutoService.detelaProdutoPorId(1L);

        // Verifique se o comportamento esperado ocorreu usando o Mockito
        Assertions.assertEquals("deletado", produtoRequest.getNomeProduto());
    }

}
