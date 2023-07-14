package models;

public abstract class Usuario {
    private int id;
    private String nome;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, TipoUsuario tipoUsuario){
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
