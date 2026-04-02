import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Loja {
    private String brandName;
    private List<Produto> productList;
    private List<Venda> salesList;
    Random gerador = new Random();
    Scanner scan = new Scanner(System.in);

    public Loja() {
        this.brandName = "";
        this.productList = new ArrayList<>();
        this.salesList = new ArrayList<>();
    }

    public void setBrandName(String brandName) { this.brandName = brandName; }
    public String getBrandName() { return this.brandName; }

    public void createProduct(String nome, double preco, int estoque) {
        int id = gerador.nextInt(1000) + 1;

        System.out.println("Tipo do produto:\n1 - Digital\n2 - Físico");
        int tipoDeProduto = scan.nextInt();

        if (tipoDeProduto == 1) {
            System.out.println("Tipo digital:\n1 - Ebook\n2 - Curso\n3 - Jogo");
            int tipoDigital = scan.nextInt();

            ProdutoDigital.tipo tipo = switch (tipoDigital) {
                case 2 -> ProdutoDigital.tipo.CURSO;
                case 3 -> ProdutoDigital.tipo.JOGO;
                default -> ProdutoDigital.tipo.EBOOK;
            };

            ProdutoDigital produto = new ProdutoDigital();
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setEstoque(estoque);
            produto.setTipoPdt(tipoPdt.DIGITAL);
            produto.setTipo(tipo);
            productList.add(produto);

        } else {
            System.out.print("Peso (kg): ");
            double peso = scan.nextDouble();

            ProdutoFisico produto = new ProdutoFisico();
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setEstoque(estoque);
            produto.setTipoPdt(tipoPdt.FISICO);
            produto.setPeso(peso);
            productList.add(produto);
        }

        System.out.println("Produto cadastrado com sucesso!");
    }

    public void makeSale() {
        if (productList.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        showProductList();

        System.out.println("Tipo de venda:\n1 - Único produto\n2 - Múltiplos produtos");
        int tipoVenda = scan.nextInt();

        if (tipoVenda == 1) {
            System.out.print("ID do produto: ");
            int idEscolhido = scan.nextInt();

            Produto encontrado = null;
            for (Produto p : productList) {
                if (p.getId() == idEscolhido) {
                    encontrado = p;
                    break;
                }
            }

            if (encontrado == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            if (encontrado.getEstoque() == 0) {
                System.out.println("Produto sem estoque!");
                return;
            }

            VendaUnicoProduto venda = new VendaUnicoProduto();
            venda.setProduto(encontrado);
            encontrado.setEstoque(encontrado.getEstoque() - 1);
            salesList.add(venda);
            System.out.printf("Venda realizada! Total: R$ %.2f%n", venda.calcularTotal());

        } else {
            VendaMultiplosProdutos venda = new VendaMultiplosProdutos();
            String continuar = "s";

            while (continuar.equalsIgnoreCase("s")) {
                System.out.print("ID do produto: ");
                int idEscolhido = scan.nextInt();

                for (Produto p : productList) {
                    if (p.getId() == idEscolhido) {
                        if (p.getEstoque() == 0) {
                            System.out.println("Sem estoque, pulando.");
                        } else {
                            venda.addProduto(p);
                            p.setEstoque(p.getEstoque() - 1);
                            System.out.println("Adicionado: " + p.getNome());
                        }
                        break;
                    }
                }

                scan.nextLine();
                System.out.print("Adicionar outro? (s/n): ");
                continuar = scan.nextLine();
            }

            salesList.add(venda);
            System.out.printf("Venda realizada! Total com desconto: R$ %.2f%n", venda.calcularTotal());
        }
    }

    public void showProductList() {
        System.out.println("\n--- Produtos ---");
        for (Produto p : productList) {
            System.out.printf("[%d] %s | R$ %.2f | Estoque: %d | Tipo: %s%n",
                    p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.getTipoPdt().getDesc());
        }
    }

    public void showSalesList() {
        System.out.println("\n--- Vendas ---");
        if (salesList.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
            return;
        }
        for (Venda v : salesList) {
            if (v instanceof VendaUnicoProduto vs) {
                System.out.printf("Venda simples | Produto: %s | Total: R$ %.2f%n",
                        vs.getProduto().getNome(), vs.calcularTotal());
            } else if (v instanceof VendaMultiplosProdutos vm) {
                System.out.printf("Venda múltipla | %d produtos | Total: R$ %.2f%n",
                        vm.getProdutoList().size(), vm.calcularTotal());
            }
        }
    }

    enum tipoPdt {
        FISICO("Fisico"),
        DIGITAL("Digital");

        private String desc;
        tipoPdt(String desc) { this.desc = desc; }
        public String getDesc() { return desc; }
    }
}