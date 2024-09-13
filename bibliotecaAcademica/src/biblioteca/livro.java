package biblioteca;

public class livro {
    private String titulo;
    private biblioteca.autor autor;
    private String idLivro;

    public livro(String titulo, autor autor, String idLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public biblioteca.autor getAutor() {
        return autor;
    }

    public void setAutor(autor autor) {
        this.autor = autor;
    }

    public String getidLivro() {
        return idLivro;
    }

    public void setidLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.toString() + " (Código: " + idLivro + ")";
    }
}




