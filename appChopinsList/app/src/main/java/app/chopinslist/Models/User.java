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

    public User(int id, String login, String senha) {
        this.setId(id);
        this.setLogin(login);
        this.setSenha(senha);
    }

    private int id;
    private String login;
    private String senha;

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


}
