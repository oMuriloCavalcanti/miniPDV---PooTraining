//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Loja loja = new Loja();
    loja.createDigitalProduct("Curso Java Completo", 199.90, 50, Loja.tipoPdt.DIGITAL, ProdutoDigital.tipo.EBOOK);
    loja.createDigitalProduct("Ebook Clean Code", 49.90, 100, Loja.tipoPdt.DIGITAL,ProdutoDigital.tipo.EBOOK);
    loja.createDigitalProduct("Template React Dashboard", 79.90, 30, Loja.tipoPdt.DIGITAL,ProdutoDigital.tipo.EBOOK);
    loja.createDigitalProduct("API REST Node.js", 149.90, 40, Loja.tipoPdt.DIGITAL,ProdutoDigital.tipo.EBOOK);
    loja.showProductList();
}
