package padroesestruturais.composite;
import java.util.Locale;

public class ItemCardapio implements ComponenteCardapio {
    private String nome;
    private String descricao;
    private double preco;

    public ItemCardapio(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return nome + " - " + descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void adicionar(ComponenteCardapio componente) {
        throw new UnsupportedOperationException("Item avulso não pode conter outros itens.");
    }

    @Override
    public void remover(ComponenteCardapio componente) {
        throw new UnsupportedOperationException("Item avulso não pode conter outros itens.");
    }

    @Override
    public ComponenteCardapio getFilho(int index) {
        throw new UnsupportedOperationException("Item avulso não possui filhos.");
    }

    @Override
    public void imprimir(int profundidade) {
        StringBuilder indentacao = new StringBuilder();
        for (int i = 0; i < profundidade; i++) indentacao.append("  ");
        System.out.println(indentacao.toString() + getDescricao() + " - R$ " + String.format(Locale.US, "%.2f", getPreco()));
    }
}
