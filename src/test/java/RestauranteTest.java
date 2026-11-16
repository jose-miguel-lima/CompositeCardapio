import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    @Test
    void deveRetornarCardapioRestaurante() {
        Secao secao1 = new Secao("Sobremesas");

        Secao secao2 = new Secao("Entradas");
        Prato prato21 = new Prato("Bruschetta", 18.5f);
        secao2.addItem(prato21);

        Secao secao3 = new Secao("Pratos Principais");
        Prato prato31 = new Prato("Risoto de cogumelos", 42.0f);
        Secao secao32 = new Secao("Massas");
        Prato prato321 = new Prato("Lasanha", 38.0f);
        Prato prato322 = new Prato("Nhoque", 35.5f);
        secao32.addItem(prato321);
        secao32.addItem(prato322);
        secao3.addItem(prato31);
        secao3.addItem(secao32);

        Secao cardapio = new Secao("Cardápio de Inverno");
        cardapio.addItem(secao1);
        cardapio.addItem(secao2);
        cardapio.addItem(secao3);

        Restaurante restaurante = new Restaurante();
        restaurante.setCardapio(cardapio);

        assertEquals("Seção: Cardápio de Inverno\n" +
                "Seção: Sobremesas\n" +
                "Seção: Entradas\n" +
                "Prato: Bruschetta - preço: 18.5\n" +
                "Seção: Pratos Principais\n" +
                "Prato: Risoto de cogumelos - preço: 42.0\n" +
                "Seção: Massas\n" +
                "Prato: Lasanha - preço: 38.0\n" +
                "Prato: Nhoque - preço: 35.5\n", restaurante.getCardapio());
    }

    @Test
    void deveRetornarExcecaoRestauranteSemCardapio() {
        try {
            Restaurante restaurante = new Restaurante();
            restaurante.getCardapio();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Restaurante sem cardápio", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoAoContarPratosRestauranteSemCardapio() {
        try {
            Restaurante restaurante = new Restaurante();
            restaurante.getQuantidadePratos();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Restaurante sem cardápio", e.getMessage());
        }
    }

    @Test
    void deveContarPratosDeTodosOsNiveis() {
        Secao massas = new Secao("Massas");
        massas.addItem(new Prato("Lasanha", 38.0f));
        massas.addItem(new Prato("Nhoque", 35.5f));

        Secao principais = new Secao("Pratos Principais");
        principais.addItem(new Prato("Risoto de cogumelos", 42.0f));
        principais.addItem(massas);

        Secao cardapio = new Secao("Cardápio de Inverno");
        cardapio.addItem(new Secao("Sobremesas"));
        cardapio.addItem(principais);

        Restaurante restaurante = new Restaurante();
        restaurante.setCardapio(cardapio);

        assertEquals(3, restaurante.getQuantidadePratos());
    }

    @Test
    void deveTratarUmPratoIsoladoComoCardapio() {
        Restaurante restaurante = new Restaurante();
        restaurante.setCardapio(new Prato("Prato do dia", 29.9f));

        assertEquals("Prato: Prato do dia - preço: 29.9\n", restaurante.getCardapio());
        assertEquals(1, restaurante.getQuantidadePratos());
    }

    @Test
    void deveRefletirPratoAdicionadoDepoisDeDefinirOCardapio() {
        Secao cardapio = new Secao("Cardápio");
        Restaurante restaurante = new Restaurante();
        restaurante.setCardapio(cardapio);
        assertEquals(0, restaurante.getQuantidadePratos());

        cardapio.addItem(new Prato("Bruschetta", 18.5f));
        assertEquals(1, restaurante.getQuantidadePratos());
        assertEquals("Seção: Cardápio\nPrato: Bruschetta - preço: 18.5\n", restaurante.getCardapio());
    }

}
