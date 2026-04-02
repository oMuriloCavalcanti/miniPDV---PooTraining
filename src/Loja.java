import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String brandName;
    private List<Produto> productList;
    private List<Venda> salesList;

    public Loja(){
        this.brandName = "";
        this.productList = new ArrayList<Produto>();
    }

    public void setBrandName(String brandName){ this.brandName = brandName;}
    public String getBrandName(){ return this.brandName;}

    public void makeSale(){
        // Parametros viram venda e venda é atribuida à salesList
    }

    public void createProduct(){
        // Parametros viram produto e produto é atribuida à productList

    }

    public void showProductList(){

    }

    public void showSalesList(){

    }

}
