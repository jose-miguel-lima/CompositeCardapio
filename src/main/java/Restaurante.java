public class Restaurante {

    private ItemCardapio cardapio;

    public void setCardapio(ItemCardapio cardapio) {
        this.cardapio = cardapio;
    }

    public String getCardapio() {
        if (this.cardapio == null) {
            throw new NullPointerException("Restaurante sem cardápio");
        }
        return this.cardapio.getCardapio();
    }

    public int getQuantidadePratos() {
        if (this.cardapio == null) {
            throw new NullPointerException("Restaurante sem cardápio");
        }
        return this.cardapio.getQuantidadePratos();
    }
}
