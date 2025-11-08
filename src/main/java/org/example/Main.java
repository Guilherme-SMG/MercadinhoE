package org.example;

/**
  Classe de inicialização do sistema.
  Demonstra o uso dos padrões GRASP aplicados:
  Creator (na classe Venda)
 Controller (na classe MercadinhoController)
 */
public class Main {
    public static void main(String[] args) {
        MercadinhoController controller = new MercadinhoController();

        // Cadastro de produtos no catálogo
        controller.cadastrarProduto("A01", "Arroz 5kg", 25.0, 10);
        controller.cadastrarProduto("F02", "Feijão 1kg", 8.5, 15);
        controller.cadastrarProduto("L03", "Leite 1L", 4.5, 20);

        controller.listarProdutos();

        // Criando uma venda
        Venda venda = controller.criarVenda();

        // Adicionando itens (Creator)
        venda.adicionarItem(controller.buscarProdutoPorId("A01"), 2);
        venda.adicionarItem(controller.buscarProdutoPorId("L03"), 3);

        // Exibindo a venda
        System.out.println("\n=== ITENS DA VENDA ===");
        venda.exibirItens();
        System.out.printf("TOTAL: R$ %.2f%n", venda.calcularTotal());

        System.out.println("\n=== ESTOQUE ATUALIZADO ===");
        controller.listarProdutos();
    }
}