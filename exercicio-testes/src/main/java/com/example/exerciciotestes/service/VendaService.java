package com.example.exerciciotestes.service;

import com.example.exerciciotestes.controller.request.VendaRequest;
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
        Venda venda = new Venda();
        venda.setValorVenda(vendaRequest.getValorVenda());
        venda.setCliente(clienteService.buscaClientePorId(vendaRequest.getClienteId()));

        List<Produto> produtos = new ArrayList<>();
        for (Long produtoId : vendaRequest.getProdutos()) {
            produtos.add(produtoService.buscaProdutoPorId(produtoId));
        }
        venda.setProdutos(produtos);

        return this.VendaRepository.save(venda);
    }

    public Venda buscaVendaPorId (Long id){
        return this.VendaRepository.findById(id).orElse(null);
    }

}
