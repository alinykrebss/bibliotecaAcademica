package biblioteca;

import java.util.Date;

public class emprestimo {
    private livro livro;
    private usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public emprestimo(livro livro, usuario usuario, Date dataEmprestimo, Date dataDevolucaoPrevista) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucaoPrevista;
    }

    public livro getLivro() {
        return livro;
    }

    public void setLivro(livro livro) {
        this.livro = livro;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucao;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucao = dataDevolucaoPrevista;
    }

    @Override
    public String toString() {
        return "Empréstimo: " + livro.getTitulo() + " para " + usuario.getNome() + " em " + dataEmprestimo + ". Devolução prevista: " + dataDevolucao;
    }

}


