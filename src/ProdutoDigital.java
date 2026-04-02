public class ProdutoDigital extends Produto{
    private tipo tipo;

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public tipo getTipo(){
        return this.tipo;
    }

    enum tipo {
        EBOOK("EBook"),
        CURSO("Curso"),
        JOGO("Jogo");

        private String desc;
        tipo(String desc) {
            this.desc = desc;
        }

        public String getDesc(){
            return desc;
        }
    }
}
