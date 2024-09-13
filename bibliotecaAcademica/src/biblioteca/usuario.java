package biblioteca;

public class usuario {
    private String nome;
    private String senha;

    public usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;

    }

    public void Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome + " (senha: " + senha + ")";
    }
}


