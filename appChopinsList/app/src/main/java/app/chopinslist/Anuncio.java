package app.chopinslist;

public class Anuncio {

    public Anuncio(){

    }

    private String tituloAnun ;
    private String descAnun;

    public String getDescAnun() {
        return descAnun;
    }

    public String getTituloAnun() {
        return tituloAnun;
    }

    public void setDescAnun(String descAnun) {
        this.descAnun = descAnun;
    }

    public void setTituloAnun(String tituloAnun) {
        this.tituloAnun = tituloAnun;
    }
}
