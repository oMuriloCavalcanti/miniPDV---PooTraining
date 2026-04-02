import java.util.Date;

public class VendaUnicoProduto extends Venda{
    private Produto produto;

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public double calcularTotal() {
        return produto.getPreco();
    }


}
