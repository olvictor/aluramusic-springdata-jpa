package com.example.alura_music.principal;

import com.example.alura_music.models.Artista;
import com.example.alura_music.repository.ArtistaRepository;

import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);

    ArtistaRepository repository;

    public Principal(ArtistaRepository repositorio) {
        this.repository = repositorio;
    }

    public void exibirMenu(){
        System.out.println("Digite o nome do artista :");
        var nomeArtista = leitura.nextLine();
        System.out.println("Esse artista é solo, banda ou dupla ?");
        var tipo = leitura.nextLine();
//        List<Artista> artistas = repository.findAll();
        salvarArtista(nomeArtista,tipo);
    }



    public void  salvarArtista(String nome, String tipo){
        Artista artista = new Artista(nome, tipo);
        repository.save(artista);
    }
}
