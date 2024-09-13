package view;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

class  autor {
    String nome;

    public autor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

class Livro {
    String titulo;
    autor autor;
    boolean emprestado;

    public Livro(String titulo, autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}

class Usuario {
    String nome;
    String senha;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome + " (" + senha + ")";
    }
}

class Emprestimo {
    Livro livro;
    Usuario usuario;
    Date dataEmprestimo;
    Date dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        this.dataDevolucao = calendar.getTime();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Livro: " + livro +
                "\nUsuário: " + usuario +
                "\nData de Empréstimo: " + sdf.format(dataEmprestimo) +
                "\nData de Devolução : " + sdf.format(dataDevolucao);
    }
}

public class principal {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

     principal() {
        autor machado = new  autor("Machado de Assis");
        autor tolkien = new  autor("J.R.R. Tolkien");
        autor orwell = new  autor("George Orwell");
         autor Miura = new  autor("Kentaro Miura");

        livros.add(new Livro("Dom Casmurro", machado));
        livros.add(new Livro("O Senhor dos Anéis", tolkien));
        livros.add(new Livro("1984", orwell));
         livros.add(new Livro("berserk", Miura ));
    }

    public void listarLivros() {
        StringBuilder listaLivros = new StringBuilder();
        for (Livro livro : livros) {
            String status = livro.emprestado ? "Emprestado" : "Disponível";
            listaLivros.append(livro).append(" (").append(status).append(")\n");
        }
        JOptionPane.showMessageDialog(null, listaLivros.toString(), "Livros Disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }


    public void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor:");
        if (titulo != null && nomeAutor != null) {
            autor autor = new  autor(nomeAutor);
            livros.add(new Livro(titulo, autor));
            JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
        }
    }

    public void cadastrarUsuario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String email = JOptionPane.showInputDialog("Digite a senha do usuário:");
        if (nome != null && email != null) {
            usuarios.add(new Usuario(nome, email));
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
    }

    public void listarUsuarios() {
        StringBuilder listaUsuarios = new StringBuilder();
        for (Usuario usuario : usuarios) {
            listaUsuarios.append(usuario).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaUsuarios.toString(), "Usuários Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }


    public void emprestarLivro() {
        String tituloLivro = JOptionPane.showInputDialog("Digite o título do livro a ser emprestado:");
        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário que fará o empréstimo:");

        Livro livroEmprestar = null;
        for (Livro livro : livros) {
            if (livro.titulo.equalsIgnoreCase(tituloLivro) && !livro.emprestado) {
                livroEmprestar = livro;
                break;
            }
        }

        if (livroEmprestar == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado ou já emprestado.");
            return;
        }

        Usuario usuarioEmprestar = null;
        for (Usuario usuario : usuarios) {
            if (usuario.nome.equalsIgnoreCase(nomeUsuario)) {
                usuarioEmprestar = usuario;
                break;
            }
        }

        if (usuarioEmprestar == null) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(livroEmprestar, usuarioEmprestar);
        livroEmprestar.emprestado = true;
        emprestimos.add(emprestimo);
        JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!\n" + emprestimo);
    }

    public void devolverLivro() {
        String tituloLivro = JOptionPane.showInputDialog("Digite o título do livro a ser devolvido:");
        Emprestimo emprestimoDevolver = null;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.livro.titulo.equalsIgnoreCase(tituloLivro) && emprestimo.livro.emprestado) {
                emprestimoDevolver = emprestimo;
                break;
            }
        }

        if (emprestimoDevolver == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado ou não está emprestado.");
            return;
        }

        emprestimoDevolver.livro.emprestado = false;
        emprestimos.remove(emprestimoDevolver);
        JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
    }

    public static void main(String[] args) {
        principal principal = new principal();

        while (true) {
            String[] opcoes = {"Listar Livros", "Adicionar Livro", "Cadastrar Usuário", "Listar Usuários", "Emprestar Livro", "Devolver Livro", "Sair"};
            int opcao = JOptionPane.showOptionDialog(null,
                    "Escolha o que deseja fazer",
                    "Biblioteca Acadêmica",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);

            switch (opcao) {
                case 0:
                    principal.listarLivros();
                    break;
                case 1:
                    principal.adicionarLivro();
                    break;
                case 2:
                    principal.cadastrarUsuario();
                    break;
                case 3:
                    principal.listarUsuarios();
                    break;
                case 4:
                    principal.emprestarLivro();
                    break;
                case 5:
                    principal.devolverLivro();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
