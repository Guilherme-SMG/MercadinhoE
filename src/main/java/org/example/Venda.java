package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 Classe responsável por armazenar os itens de uma venda.

 GRASP: Creator — A classe Venda cria seus próprios ItemVenda,
 pois ela tem a informação necessária (Produto e Quantidade)
 para isso, mantendo alta coesão e baixo acoplamento.
 */
public class Venda {
    private List<ItemVenda> itens = new ArrayList<>();

    /**
     Adiciona um produto à venda, se houver estoque suficiente.
     */
    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.temEstoqueSuficiente(quantidade)) {
            ItemVenda item = new ItemVenda(produto, quantidade);
            itens.add(item);
            produto.baixarEstoque(quantidade);
        } else {
            System.err.println("Estoque insuficiente para o produto: " + produto.getNome());
        }
    }

    /**
     Calcula o valor total da venda.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    /**
     Exibe os itens vendidos.
     */
    public void exibirItens() {
        for (ItemVenda item : itens) {
            System.out.println(item);
        }
    }
}
