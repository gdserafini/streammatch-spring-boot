package br.alura.streammatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.alura.streammatch.userInterface.Menu;

@SpringBootApplication
public class StreammatchApplication implements CommandLineRunner {

	private Menu menu = new Menu();

	public static void main(String[] args) {
		SpringApplication.run(StreammatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try{
			System.out.println("Bem vindo ao StreamMatch!");
			menu.run();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
