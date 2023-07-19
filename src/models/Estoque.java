package models;

public class Estoque {
    private Produto produto;
    private int quantidade;
    private String id;


    public Estoque(String id, Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.id = id;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    
}
