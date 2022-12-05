package br.com.capy.domain;

public enum TipoUso {
    ORAL("Oral"),INTRAVENOSO("Intravenoso"),SUBCUTANEO("Subcutaneo"),INTRAMUSCULAR("Intramuscular"),TOPICO("Topico"),NASAL("Nasal");

    private String tipo;

    TipoUso(String tipo) {
        this.tipo = tipo;
    }
    public String  getTipo(){
        return this.tipo;
    }
}
