package com.example.exerciciotestes.service;

import com.example.exerciciotestes.controller.request.VendaRequest;
import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.model.Produto;
import com.example.exerciciotestes.model.Venda;
import com.example.exerciciotestes.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository VendaRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public VendaService(VendaRepository VendaRepository, ClienteService clienteService, ProdutoService produtoService) {
        this.VendaRepository = VendaRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }


    public List<Venda> buscaTodosVendas(){
        return this.VendaRepository.findAll();
    }

    public Venda realizarVenda(VendaRequest vendaRequest){
        Cliente cliente = clienteService.buscaClientePorId(vendaRequest.getClienteId());

        List<Produto> listaProduto = new ArrayList<>();
        vendaRequest.getProdutos().forEach(id->
                listaProduto.add(produtoService.buscaProdutoPorId(id)));

        return this.VendaRepository.save(new Venda(vendaRequest.getValorVenda(),cliente,listaProduto));
    }

    public Venda buscaVendaPorId (Long id){
        return this.VendaRepository.findById(id).orElse(null);
    }

}
