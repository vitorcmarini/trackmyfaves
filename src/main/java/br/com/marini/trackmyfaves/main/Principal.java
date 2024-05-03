package br.com.marini.trackmyfaves.main;

import br.com.marini.trackmyfaves.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();

    private final String BASE_URL = "https://api.jikan.moe/v4";

    public void menuPrincipal(){
        var opcao = -1;
        while (opcao !=0) {
            var menu = """
                    ---------------------------
                    1 - Buscar Anime
                    2 - Buscar Manga
                                    
                    0 - Sair
                                    
                    Didite a opção desejada:
                    ---------------------------                               
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarAnime();
                    break;
                case 2:
                    buscarManga();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void buscarAnime() {
        var json = consumo.obterDados(BASE_URL + "/anime");
        System.out.println("Opção Animes selecionada !");
        System.out.println(json);

    }

    private void buscarManga() {
        var json = consumo.obterDados(BASE_URL + "/manga");
        System.out.println("Opção Mangas selecionada !");
        System.out.println(json);
    }
}
