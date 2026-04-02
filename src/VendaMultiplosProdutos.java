import java.util.ArrayList;
import java.util.List;

public class VendaMultiplosProdutos extends Venda {
    private List<Produto> produtoList;
    private double desconto = 0.10;

    public VendaMultiplosProdutos() {
        this.produtoList = new ArrayList<>(); // inicializa a lista!
    }

    public void addProduto(Produto pdt) {
        this.produtoList.add(pdt);
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    @Override
    public double calcularTotal() {
        double soma = 0;
        for (Produto p : produtoList) {
            soma += p.getPreco();
        }
        return soma - (soma * desconto); // aplica o desconto
    }
}