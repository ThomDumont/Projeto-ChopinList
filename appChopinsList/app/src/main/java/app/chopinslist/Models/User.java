package app.chopinslist.Models;

public class User {

    public User(){
    }

    public User(int id, String login, String senha){
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
