import java.util.ArrayList;
import java.util.List;

public class Secao extends ItemCardapio {

    private List<ItemCardapio> itens;

    public Secao(String descricao) {
        super(descricao);
        this.itens = new ArrayList<ItemCardapio>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public String getCardapio() {
        String saida = "";
        saida = "Seção: " + this.getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getCardapio();
        }
        return saida;
    }

    public int getQuantidadePratos() {
        int quantidade = 0;
        for (ItemCardapio item : itens) {
            quantidade += item.getQuantidadePratos();
        }
        return quantidade;
    }
}
