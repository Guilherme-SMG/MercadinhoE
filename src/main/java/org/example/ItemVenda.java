package org.example;

/**
 Representa um item individual dentro de uma venda.
 Cada ItemVenda tem um produto e uma quantidade vendida.
 */
public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    /**
     Construtor — recebe o produto e a quantidade.
     O preço unitário é capturado do Produto no momento da venda.
     */
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPrecoAtual();
    }

    /**
     Retorna o subtotal deste item (preço unitário * quantidade).
     */
    public double getSubtotal() {
        return precoUnitario * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s x%d = R$%.2f",
                produto.getNome(), quantidade, getSubtotal());
    }
}