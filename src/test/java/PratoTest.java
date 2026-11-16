import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PratoTest {

    @Test
    void deveRetornarCardapioDoPrato() {
        Prato prato = new Prato("Bruschetta", 18.5f);
        assertEquals("Prato: Bruschetta - preço: 18.5\n", prato.getCardapio());
    }

    @Test
    void deveContarUmPrato() {
        assertEquals(1, new Prato("Bruschetta", 18.5f).getQuantidadePratos());
    }

    @Test
    void deveAtualizarPrecoEDescricao() {
        Prato prato = new Prato("Bruschetta", 18.5f);
        prato.setPreco(20.0f);
        prato.setDescricao("Bruschetta de tomate");
        assertEquals("Prato: Bruschetta de tomate - preço: 20.0\n", prato.getCardapio());
    }

}
