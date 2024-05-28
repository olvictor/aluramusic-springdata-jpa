package com.example.alura_music.models;

import jakarta.persistence.*;

@Entity
@Table(name= "musicas")

public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String album;
    private Long duracaoEmSegundos;

    @ManyToOne
    private Artista artista;

    public Musica(){};
    public Musica(String nomeMusica, String nomeAlbum, Long duracao) {
        this.nome = nomeMusica;
        this.album = nomeAlbum;
        this.duracaoEmSegundos = duracao;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", album='" + album + '\'' +
                ", duracaoEmSegundos=" + duracaoEmSegundos +
                ", artista=" + artista.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getDuracaoEmSegundos() {
        return duracaoEmSegundos;
    }

    public void setDuracaoEmSegundos(Long duracaoEmSegundos) {
        this.duracaoEmSegundos = duracaoEmSegundos;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
