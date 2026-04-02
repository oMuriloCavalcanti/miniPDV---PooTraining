import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Loja {
    private String brandName;
    private List<Produto> productList;
    private List<Venda> salesList;
    Random gerador = new Random();
    public Loja(){
        this.brandName = "";
        this.productList = new ArrayList<Produto>();
        this.salesList = new ArrayList<Venda>();

    }

    public void setBrandName(String brandName){ this.brandName = brandName;}
    public String getBrandName(){ return this.brandName;}

    public void makeSale(){

    }

    public void createDigitalProduct(String nome, double preco, int estoque, tipoPdt tipoPdt){
        int id = gerador.nextInt(1000) + 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Esse produto é físico ou digital?\n1 - Digital \n 2 - Físico");
        int tipoDeProduto = scan.nextInt();

        if(tipoDeProduto == 1){
            System.out.printf("Produto Digital - Defina um tipo à ele:");
            ProdutoDigital produto = new ProdutoDigital();
            produto.setEstoque(estoque);
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setTipoPdt(tipoPdt);
            produto.setTipo(ProdutoDigital.tipo.EBOOK);
            productList.add(produto);
        }else{
            System.out.printf("Produto Físico - Defina um peso à ele:");
            double peso = scan.nextDouble();
            ProdutoFisico produto = new ProdutoFisico();
            produto.setEstoque(estoque);
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setTipoPdt(tipoPdt);
            produto.setPeso(peso);
            productList.add(produto);
        }



    }


    public void showProductList(){
        List<Produto> productList = this.productList;
        for(int i = 0; i <= productList.size() - 1; i++){
            System.out.println(productList.get(i).getNome());
        }
    }

    public void showSalesList(){

    }

    enum tipoPdt {
        FISICO("Fisico"),
        DIGITAL("Digital");

        private String desc;
        tipoPdt(String desc) {
            this.desc = desc;
        }

        public String getDesc(){
            return desc;
        }
    }
}
