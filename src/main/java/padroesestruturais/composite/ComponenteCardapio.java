package padroesestruturais.composite;

public interface ComponenteCardapio {
    String getDescricao();
    double getPreco();
    void adicionar(ComponenteCardapio componente);
    void remover(ComponenteCardapio componente);
    ComponenteCardapio getFilho(int index);
    void imprimir(int profundidade);
}
