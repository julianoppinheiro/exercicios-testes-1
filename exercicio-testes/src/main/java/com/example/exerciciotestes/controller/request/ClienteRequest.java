package com.example.exerciciotestes.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteRequest {

  private Long id;
  private String nomeCliente;
  private Double saldoCliente;

}
