public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private Loja.tipoPdt tipoPdt;

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoPdt(Loja.tipoPdt tipoPdt) {
        this.tipoPdt = tipoPdt;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Loja.tipoPdt getTipoPdt() {
        return tipoPdt;
    }
}
