package app.chopinslist.Models;


import java.io.Serializable;

public class User implements Serializable {

    public User() {
    }
    public User(String login, String senha){
        this.setId(0);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public User(int id, String login, String senha, String email, String nome, String telefone ) {
        this.setId(id);
        this.setLogin(login);
        this.setSenha(senha);
        this.setEmail(email);
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    private int id;
    private String login;
    private String senha;
    private String email;
    private String nome;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
