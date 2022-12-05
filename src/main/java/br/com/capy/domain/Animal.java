package br.com.capy.domain;

public enum Animal {
    CACHORRO("Cachorro"),GATO("Gato");

    private String animal;

    Animal(String animal) {
        this.animal = animal;
    }

    public String getAnimal(){
        return this.animal;
    }
}
