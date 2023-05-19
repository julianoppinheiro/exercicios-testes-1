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

        //cria alguns cliente para ser retornado pelo método findAll
        Mockito.when(repository.findAll()).thenReturn(List.of(
                new Cliente(1L, "Cliente 1", 12.0),
                new Cliente(2L, "Cliente 2", 10.0),
                new Cliente(3L, "Cliente 3", 15.0),
                new Cliente(4L, "Cliente 4", 20.0)));

        //executa o teste
        List<Cliente> clientes = repository.findAll();

        //verifica o resultado dentro do ArrayList
        Assertions.assertThat(clientes).hasSize(4);
        Assertions.assertThat(clientes.get(0).getNomeCliente()).isEqualTo("Cliente 1");
        Assertions.assertThat(clientes.get(1).getNomeCliente()).isEqualTo("Cliente 2");
        Assertions.assertThat(clientes.get(2).getNomeCliente()).isEqualTo("Cliente 3");
    }

    @Test
    @DisplayName("Deve retornar um cliente quando o id existir")
    void buscaClientePorId(){
        //prepara o ambiente para o teste
        ClienteRepository repository = Mockito.mock(ClienteRepository.class);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new Cliente(1L, "Cliente 1", 10.0)));

        //executa o teste
        Cliente cliente = repository.findById(1L).get();

        //verifica o resultado dentro do for
        Assertions.assertThat(cliente.getNomeCliente()).isEqualTo("Cliente 1");


    }
}
