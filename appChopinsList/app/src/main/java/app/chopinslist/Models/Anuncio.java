package app.chopinslist.Models;

import java.io.Serializable;

public class Anuncio implements Serializable {

    private int id;
    private String titulo;
    private String desc;

    public Anuncio(){
    }

    public Anuncio( String titulo, String desc){
        this.setTitulo(titulo);
        this.setDesc(desc);
    }


    public Anuncio(int id, String titulo, String desc){
        this.setId(id);
        this.setTitulo(titulo);
        this.setDesc(desc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
