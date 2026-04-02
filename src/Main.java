void main() {
    Scanner scan = new Scanner(System.in);
    Loja loja = new Loja();
    loja.setBrandName("Umbrella Corp Ltda.");

    loja.createProduct("Curso Java Completo", 199.90, 50);
    loja.createProduct("Tênis Nike", 349.90, 20);

    int opcao = -1;
    while (opcao != 0) {
        System.out.println("\n=== " + loja.getBrandName() + " ===");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Realizar venda");
        System.out.println("4 - Listar vendas");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                scan.nextLine();
                System.out.print("Nome: ");
                String nome = scan.nextLine();
                System.out.print("Preço: ");
                double preco = scan.nextDouble();
                System.out.print("Estoque: ");
                int estoque = scan.nextInt();
                loja.createProduct(nome, preco, estoque);
            }
            case 2 -> loja.showProductList();
            case 3 -> loja.makeSale();
            case 4 -> loja.showSalesList();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida!");
        }
    }
}