package org.example;

import java.util.List;
import java.util.ArrayList;

/**
 * GRASP: Controller — centraliza a lógica de aplicação
 * (cadastro, busca e controle de vendas), separando da interface e das entidades.
 */
public class MercadinhoController {
    private List<Produto> produtos = new ArrayList<>();

    /**
     Cadastra um novo produto no catálogo do mercadinho.
     */
    public void cadastrarProduto(String id, String nome, double preco, int estoque) {
        produtos.add(new Produto(id, nome, preco, estoque));
    }

    /**
     Lista todos os produtos disponíveis.
     */
    public void listarProdutos() {
        System.out.println("=== PRODUTOS DISPONÍVEIS ===");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    /**
     Busca um produto pelo seu ID (ex: código de barras).
     */
    public Produto buscarProdutoPorId(String id) {
        for (Produto p : produtos) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     Cria uma nova venda.
     */
    public Venda criarVenda() {
        return new Venda();
    }
}