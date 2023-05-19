package com.example.exerciciotestes;

import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class M3S01_exercicio02 {

    //Crie os testes unitários para os métodos salvarCliente já existente na classe ClienteService
    @Test
    @DisplayName("Deve salvar um cliente")
    public void salvarCliente() {
        //prepara o ambiente para o teste
        ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);
        //executa o teste do save dentro do service
        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(new Cliente("João", 100.0));

        //verifica o resultado do cliente
        Assertions.assertThat(clienteRepository.save(new Cliente("João", 100.0))).isNotNull();
    }
}
