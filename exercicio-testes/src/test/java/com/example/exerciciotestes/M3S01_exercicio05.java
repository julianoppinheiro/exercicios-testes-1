package com.example.exerciciotestes;

import com.example.exerciciotestes.controller.request.ProdutoRequest;
import com.example.exerciciotestes.model.Produto;
import com.example.exerciciotestes.repository.ProdutoRepository;
import com.example.exerciciotestes.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class M3S01_exercicio05 {

    @Test
    @DisplayName("Deve buscar todos os produtos")
    public void buscarTodosProdutos() {
        //criando o objeto ProdutoRequest mockado
        ProdutoService service = new ProdutoService(mock(ProdutoRepository.class));
        ProdutoRequest produtoRequest = mock(ProdutoRequest.class);
        //criar uma lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "produto1", 10.0));
        produtos.add(new Produto(2L, "produto2", 20.0));
        when(service.buscaTodosProdutos()).thenReturn(produtos);

        // Executa o método que você deseja testar
        List<Produto> resultado = service.buscaTodosProdutos();

        // Verifica se o comportamento esperado ocorreu
        assertEquals(produtos, resultado);
    }

    @Test
    @DisplayName("Deve buscar um produto pelo id")
    public void buscarProdutoPorId() {
        //criando o objeto ProdutoRequest mockado
        ProdutoService service = new ProdutoService(mock(ProdutoRepository.class));
        //criar uma lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "produto1", 10.0));
        produtos.add(new Produto(2L, "produto2", 20.0));

        //atribui valores ao objeto mock para atualizar o produto
        when(service.buscaId(1L)).thenReturn(Optional.ofNullable(produtos.get(0)));

        // Executa o método que você deseja testar
        Produto resultado = service.buscaProdutoPorId(1L);

        // Verifica se o comportamento esperado ocorreu
        //System.out.println(resultado.getNomeProduto());
        assertEquals(produtos.get(0), resultado);
    }
}
