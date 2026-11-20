package padroesestruturais.composite;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoriaCardapio implements ComponenteCardapio {
    private String nome;
    private String descricao;
    private List<ComponenteCardapio> componentes;

    public CategoriaCardapio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.componentes = new ArrayList<>();
    }

    @Override
    public String getDescricao() {
        return nome + " - " + descricao;
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (ComponenteCardapio c : componentes) {
            total += c.getPreco();
        }
        return total;
    }

    @Override
    public void adicionar(ComponenteCardapio componente) {
        componentes.add(componente);
    }

    @Override
    public void remover(ComponenteCardapio componente) {
        componentes.remove(componente);
    }

    @Override
    public ComponenteCardapio getFilho(int index) {
        return componentes.get(index);
    }

    @Override
    public void imprimir(int profundidade) {
        StringBuilder indentacao = new StringBuilder();
        for (int i = 0; i < profundidade; i++) indentacao.append("  ");
        System.out.println(indentacao.toString() + "Categoria: " + getDescricao() + " (Total: R$ " + String.format(Locale.US, "%.2f", getPreco()) + ")");
        for (ComponenteCardapio c : componentes) {
            c.imprimir(profundidade + 1);
        }
    }
}
