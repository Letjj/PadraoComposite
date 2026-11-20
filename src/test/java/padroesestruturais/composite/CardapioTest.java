package padroesestruturais.composite;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarCardapioCompletoComPrecos() {
        CategoriaCardapio bebidas = new CategoriaCardapio("Bebidas", "Refrescantes");
        bebidas.adicionar(new ItemCardapio("Refrigerante", "Lata 350ml", 6.00));
        bebidas.adicionar(new ItemCardapio("Suco Natural", "Laranja 500ml", 10.00));

        CategoriaCardapio lanches = new CategoriaCardapio("Lanches", "Opções de fast food");
        lanches.adicionar(new ItemCardapio("X-Burguer", "Pão, carne e queijo", 18.50));

        CategoriaCardapio combos = new CategoriaCardapio("Combos", "Lanche + Bebida");
        combos.adicionar(new ItemCardapio("Combo X-Burguer", "X-Burguer + Refrigerante", 22.00));

        CategoriaCardapio cardapioPrincipal = new CategoriaCardapio("Cardápio do Restaurante", "Todos os itens disponíveis");
        cardapioPrincipal.adicionar(bebidas);
        cardapioPrincipal.adicionar(lanches);
        cardapioPrincipal.adicionar(combos);

        Cardapio cardapio = new Cardapio();
        cardapio.setCardapioPrincipal(cardapioPrincipal);

        assertEquals(56.50, cardapio.getPrecoTotal(), 0.01);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        cardapio.imprimirCardapio();

        String expectedOutput = "Categoria: Cardápio do Restaurante - Todos os itens disponíveis (Total: R$ 56.50)\n" +
                "  Categoria: Bebidas - Refrescantes (Total: R$ 16.00)\n" +
                "    Refrigerante - Lata 350ml - R$ 6.00\n" +
                "    Suco Natural - Laranja 500ml - R$ 10.00\n" +
                "  Categoria: Lanches - Opções de fast food (Total: R$ 18.50)\n" +
                "    X-Burguer - Pão, carne e queijo - R$ 18.50\n" +
                "  Categoria: Combos - Lanche + Bebida (Total: R$ 22.00)\n" +
                "    Combo X-Burguer - X-Burguer + Refrigerante - R$ 22.00\n";

        assertEquals(expectedOutput.trim().replace("\r\n", "\n"), outContent.toString().trim().replace("\r\n", "\n"));
    }

    @Test
    void deveLancarExcecaoAoAdicionarFilhoEmItem() {
        ItemCardapio item = new ItemCardapio("Batata Frita", "Porção média", 12.00);
        assertThrows(UnsupportedOperationException.class, () -> {
            item.adicionar(new ItemCardapio("Molho", "Ketchup", 2.00));
        });
    }
}