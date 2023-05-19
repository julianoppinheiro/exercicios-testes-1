package com.example.exerciciotestes;

import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class M3S01_exercicio01 {

    //testes unitários para os métodos buscaTodosClientes e buscaClientePorId já existentes na classe ClienteService

    @Test
    @DisplayName("Deve retornar uma lista de clientes")
    void buscaTodosClientes() {
        //prepara o ambiente para o teste
        ClienteRepository repository = Mockito.mock(ClienteRepository.class);
        Mockito.when(repository.findAll()).thenReturn(List.of(new Cliente(1L, "Cliente 1", 12.0)));

        //executa o teste
        List<Cliente> clientes = repository.findAll();

        //verifica o resultado
        Assertions.assertThat(clientes.size()).isEqualTo(1);
        Assertions.assertThat(clientes.get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(clientes.get(0).getNomeCliente()).isEqualTo("Cliente 1");
        Assertions.assertThat(clientes.get(0).getSaldoCliente()).isEqualTo(12.0);
    }

    @Test
    @DisplayName("Deve retornar um cliente quando o id existir")
    void buscaClientePorId(){
        //prepara o ambiente para o teste
        ClienteRepository repository = Mockito.mock(ClienteRepository.class);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new Cliente(1L, "Cliente 1", 10.0)));

        //executa o teste
        Cliente cliente = repository.findById(1L).get();

        //verifica o resultado
        Assertions.assertThat(cliente.getId()).isEqualTo(1L);
        Assertions.assertThat(cliente.getNomeCliente()).isEqualTo("Cliente 1");
        Assertions.assertThat(cliente.getSaldoCliente()).isEqualTo(10.0);
    }
}
