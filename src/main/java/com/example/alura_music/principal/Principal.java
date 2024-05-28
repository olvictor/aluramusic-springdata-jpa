package com.example.alura_music.principal;

import com.example.alura_music.models.Artista;
import com.example.alura_music.models.Tipo;
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




}
