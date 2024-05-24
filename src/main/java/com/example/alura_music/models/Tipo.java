package com.example.alura_music.models;

public enum Tipo {
    DUPLA("dupla"),
    SOLO("solo"),
    BANDA("banda");

    private String tipo;

    Tipo(String tipo){
     this.tipo = tipo;
    }
    public static Tipo fromString(String text){
        for(Tipo tipo : Tipo.values()){
            if(tipo.tipo.equalsIgnoreCase(text)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado !");
    }
}
