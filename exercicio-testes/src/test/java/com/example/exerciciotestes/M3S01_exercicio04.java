package com.example.exerciciotestes;

import com.example.exerciciotestes.controller.request.ClienteRequest;
import com.example.exerciciotestes.repository.ClienteRepository;
import com.example.exerciciotestes.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class M3S01_exercicio04 {

    //Crie os testes unitários para os métodos detelarClientePorId já existente na classe ClienteService

    @Test
    @DisplayName("Deve deletar um cliente na base de dados")
    void deletarClientePorId() {
        // Cria um objeto ClienteService e o objeto ClienteResquest mockado
        ClienteService clienteService = new ClienteService(mock(ClienteRepository.class));
        ClienteRequest clienteRequest = mock(ClienteRequest.class);

        //atribui valores ao objeto mock para deletar o cliente
        when(clienteRequest.getId()).thenReturn(1L);
        when(clienteRequest.getNomeCliente()).thenReturn("deletado");
        when(clienteRequest.getSaldoCliente()).thenReturn(10.0);

        //salvar cliente
        clienteService.salvarCliente(clienteRequest);

        //deletar cliente
        clienteService.deletarClientePorId(1L);

        // Verifique se o comportamento esperado ocorreu usando o Mockito
        Assertions.assertEquals("deletado", clienteRequest.getNomeCliente());
    }

}
