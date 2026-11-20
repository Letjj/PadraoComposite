package padroesestruturais.composite;

public class Cardapio {
    private ComponenteCardapio cardapioPrincipal;

    public void setCardapioPrincipal(ComponenteCardapio cardapioPrincipal) {
        this.cardapioPrincipal = cardapioPrincipal;
    }

    public void imprimirCardapio() {
        if (cardapioPrincipal != null) {
            cardapioPrincipal.imprimir(0);
        }
    }

    public double getPrecoTotal() {
        return cardapioPrincipal != null ? cardapioPrincipal.getPreco() : 0.0;
    }
}
