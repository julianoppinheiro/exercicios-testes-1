package com.example.exerciciotestes;

import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.service.ClienteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class M3S01_exercicio01 {

    //testes unitários para os métodos buscaTodosClientes e buscaClientePorId já existentes na classe ClienteService

    @Test
    @DisplayName("Deve retornar uma lista de clientes")
    void buscaTodosClientes() {
        //prepara o ambiente para o teste
        ClienteService service = Mockito.mock(ClienteService.class);

        //cria uma lista de clientes
        List<Cliente> clientes = List.of(
                        new Cliente(1L, "Cliente 1", 10.0),
                        new Cliente(2L, "Cliente 2", 20.0),
                        new Cliente(3L, "Cliente 3", 30.0)
        );

        //quando o método buscaTodosClientes for chamado, retorna a lista de clientes criada acima
        Mockito.when(service.buscaTodosClientes()).thenReturn(clientes);
    }

    @Test
    @DisplayName("Deve retornar um cliente quando o id existir")
    void buscaClientePorId(){
        //prepara o ambiente para o teste
        ClienteService service = Mockito.mock(ClienteService.class);

        //cria um cliente
        Cliente cliente = new Cliente(1L, "Cliente 1", 10.0);

        //buscar cliente por id
        Mockito.when(service.buscaClientePorId(1L)).thenReturn(cliente);

        ////verifica o resultado do cliente
        Assertions.assertThat(cliente.getId()).isEqualTo(1L);

    }
}
