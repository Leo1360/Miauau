package br.com.capy.domain;

public enum Porte {
    PEQUENO("Pequeno"),MEDIO("Medio"),GRANDE("Grande");

    private String porte;

    Porte(String porte) {
        this.porte = porte;
    }

    public String getPorte(){
        return this.porte;
    }
}
