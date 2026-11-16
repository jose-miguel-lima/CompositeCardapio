import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecaoTest {

    @Test
    void deveRetornarApenasADescricaoDeSecaoVazia() {
        Secao secao = new Secao("Sobremesas");
        assertEquals("Seção: Sobremesas\n", secao.getCardapio());
        assertEquals(0, secao.getQuantidadePratos());
    }

    @Test
    void deveManterAOrdemDeInsercaoDosItens() {
        Secao secao = new Secao("Bebidas");
        secao.addItem(new Prato("Suco", 8.0f));
        secao.addItem(new Prato("Água", 4.0f));
        assertEquals("Seção: Bebidas\n" +
                "Prato: Suco - preço: 8.0\n" +
                "Prato: Água - preço: 4.0\n", secao.getCardapio());
    }

    @Test
    void deveAceitarSecaoDentroDeSecao() {
        Secao interna = new Secao("Vinhos");
        interna.addItem(new Prato("Tinto da casa", 60.0f));
        Secao externa = new Secao("Bebidas");
        externa.addItem(interna);
        assertEquals("Seção: Bebidas\nSeção: Vinhos\nPrato: Tinto da casa - preço: 60.0\n", externa.getCardapio());
        assertEquals(1, externa.getQuantidadePratos());
    }

}
