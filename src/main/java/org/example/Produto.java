package org.example;

/**
 * Representa um item único no catálogo do mercadinho.
 * Esta classe é uma classe de "Modelo".
 * Ela armazena os dados e lógicas de negócio sobre um produto.
 * * 1. O 'MercadinhoController' vai buscar esta classe (ex: de um catálogo).
 * 2. A classe 'Venda' (que aplica o 'Creator') vai receber esta classe
 * como parâmetro para poder criar um 'ItemVenda'.
 */
public class Produto {

    private String id; // Ex: Código de barras
    private String nome;
    private double precoAtual;
    private int estoque;

    /**
     * Construtor para criar um novo produto no catálogo.
     */
    public Produto(String id, String nome, double precoAtual, int estoqueInicial) {
        this.id = id;
        this.nome = nome;
        this.precoAtual = precoAtual;
        this.estoque = estoqueInicial;
    }

    // --- Getters
    // Essenciais para as outras classes, como Venda e MercadinhoController


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    /**
     * O 'Creator' (classe Venda) usará este método para, criar o ItemVenda com o preço correto.
     */
    public double getPrecoAtual() {
        return precoAtual;
    }

    public int getEstoque() {
        return estoque;
    }

    // Lógica de Negócio
    // Métodos que vão manipular os dados do próprio produto.

    /**
     * Atualiza o preço de venda do produto.
     */
    public void setPrecoAtual(double novoPreco) {
        if (novoPreco > 0) { // Uma regra de negócio simples
            this.precoAtual = novoPreco;
        }
    }

    /**
     * Verifica se a quantidade desejada está disponível no estoque.
     */
    public boolean temEstoqueSuficiente(int quantidadeDesejada) {
        return this.estoque >= quantidadeDesejada;
    }

    /**
     * Remove uma quantidade do estoque, logo depois da venda no caso, e o Controller pode chamar isso.
     */
    public void baixarEstoque(int quantidade) {
        if (temEstoqueSuficiente(quantidade)) {
            this.estoque -= quantidade;
        } else {
            System.err.println("Tentativa de baixar estoque sem saldo para o produto: " + nome);
        }
    }

    /**
     * Adiciona itens ao estoque, como um recebimento do fornecedor.
     */
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.estoque += quantidade;
        }
    }

    // --- Método Utilitário ---

    /**
     * Converte o objeto para uma String mais formatada.
     */
    @Override
    public String toString() {
        return String.format("Produto [ID: %s | Nome: %s | Preço: R$%.2f | Estoque: %d]",
                id, nome, precoAtual, estoque);
    }
}