package br.alura.streammatch.userInterface;

import java.util.Scanner;

public class MenuReader {
    private Scanner scanner = new Scanner(System.in);

    public String readSerieName(){
        System.out.println("Digite o nome da série: ");
        return scanner.nextLine();
    }

    public Integer readEpisodeNumber(){
        System.out.println("Digite o número do episódio: ");
        return scanner.nextInt();
    }

    public Integer readSeasonNumber(){
        System.out.println("Digite o número da temporada: ");
        return scanner.nextInt();
    }
}
