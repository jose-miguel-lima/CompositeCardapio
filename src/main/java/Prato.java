public class Prato extends ItemCardapio {

    private float preco;

    public Prato(String descricao, float preco) {
        super(descricao);
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCardapio() {
        return "Prato: " + this.getDescricao() + " - preço: " + this.preco + "\n";
    }

    public int getQuantidadePratos() {
        return 1;
    }

}
