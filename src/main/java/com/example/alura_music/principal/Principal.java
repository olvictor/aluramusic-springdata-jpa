package com.example.alura_music.principal;

import com.example.alura_music.models.Artista;
import com.example.alura_music.models.Musica;
import com.example.alura_music.models.Tipo;
import com.example.alura_music.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);

    ArtistaRepository repository;

    public Principal(ArtistaRepository repositorio) {
        this.repository = repositorio;
    }

    public void exibirMenu(){
        var opcao = -1;

        while (opcao != 0){
            System.out.println("""
                    *** Alura Music  ***
                    1- Cadastrar artistas
                    2- Cadastrar músicas 
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisas dados sobre um artista
                    
                    
                    0- sair
                    """);

            opcao = leitura.nextInt();
            leitura.nextLine();
                switch (opcao){
                    case 0:
                        opcao = 0;
                        break;
                    case 1:
                        salvarArtista();
                        break;
                    case 2:
                        cadastrarMusica();
                        break;
                    case 3:
                        listarMusicas();
                        break;
                    default:
                        System.out.println("Opção inválida !");
                }
        }
    }



    private void salvarArtista(){

            System.out.println("Digite o nome do artista :");
            var nome = leitura.nextLine();

            System.out.println("Esse artista é solo,dupla ou banda ?");
            String tipo = leitura.nextLine();

            Artista artista = new Artista(nome, tipo);
            repository.save(artista);

    }


    private void cadastrarMusica(){
        System.out.println("Digite o nome do artista :");
        var nomeArtista = leitura.nextLine();

        Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(nomeArtista);
        if(artista.isPresent()){
            System.out.println("Digite o nome da musica :");
        var nomeMusica = leitura.nextLine();


        System.out.println("Digite o album :");
        var nomeAlbum = leitura.nextLine();

        System.out.println("Digite a duracao em segundos :");
        var duracao = leitura.nextLong();

        Musica musica = new Musica(nomeMusica,nomeAlbum,duracao);
        musica.setArtista(artista.get());
        artista.get().getMusicas().add(musica);
        repository.save(artista.get());

        }else{
            System.out.println("Artista não encontrado, registre um artista com esse nome .");
        }


    }

    private void listarMusicas(){
        List<Artista> artistas = repository.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista(){
        System.out.println("Digite o nome do artista :");
        var nomeArtista = leitura.nextLine();



    }

    private void pesquisarDadosArtista(){

    }

}
