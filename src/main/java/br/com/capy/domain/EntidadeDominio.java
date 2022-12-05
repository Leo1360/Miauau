package br.com.capy.domain;

public abstract class EntidadeDominio {
    protected int id;

    public EntidadeDominio(int id) {
        this.id = id;
    }

    public EntidadeDominio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
