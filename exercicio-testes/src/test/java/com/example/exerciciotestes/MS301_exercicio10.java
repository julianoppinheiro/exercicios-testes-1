package com.example.exerciciotestes;

import com.example.exerciciotestes.controller.request.ClienteRequest;
import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;
import com.example.exerciciotestes.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MS301_exercicio10 {

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080")
                .build();

        @MockBean
        private ClienteService clienteService;

        @Test
        @DisplayName("Testa o método GET /clientes/{id}")
        public void GetClientes() {
            List<Cliente> clientes = new ArrayList<>();

            // Cria um objeto ProdutoService e o objeto Produto mockado
            clientes.add(new Cliente(1L, "aa", 100.0));
            clientes.add(new Cliente(2L, "Jane", 200.0));

            // quando o método buscaClientePorId for chamado, retorna o cliente com id 1
            when(clienteService.buscaClientePorId(1L)).thenReturn(clientes.get(0));

            //faz a requisição GET para o endpoint /clientes
            ResponseEntity<List<Cliente>> response = restTemplate.exchange(
                    "/clientes",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Cliente>>() {});

            //verifica se o status da resposta é 200 (OK)
            assertEquals(HttpStatus.OK, response.getStatusCode());
            //necessario alterar para o último id adicionado

            assertEquals(clientes.get(0).getNomeCliente(), response.getBody().get(0).getNomeCliente());
            System.out.println(response.getBody().get(0).getNomeCliente());
        }

        @Test
        @DisplayName("Testa o método POST /clientes")
        public void PostClientes() {
            // Cria um objeto ProdutoService e o objeto Producorequest mockado
            ClienteRequest clienteRequest = mock(ClienteRequest.class);

            //atribui valores ao objeto mock para salvar o cliente
            clienteRequest.setNomeCliente("João");
            clienteRequest.setSaldoCliente(100.0);

            //quando o método salvarCliente for chamado, retorna um novo cliente
            when(clienteService.salvarCliente(clienteRequest)).thenReturn(new Cliente("João", 100.0));

            //faz a requisição POST para o endpoint /clientes
            ResponseEntity<Cliente> response = restTemplate.postForEntity(
                    "/clientes",
                    clienteRequest,
                    Cliente.class);

            //verifica se o status da resposta é 201 (CREATED)
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            //verifica se o nome do cliente retornado é o mesmo que foi passado
            assertEquals(clienteRequest.getNomeCliente(), response.getBody().getNomeCliente());
        }
    }



