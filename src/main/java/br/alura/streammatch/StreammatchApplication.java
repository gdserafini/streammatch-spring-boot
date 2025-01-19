package br.alura.streammatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.alura.streammatch.model.Episode;
import br.alura.streammatch.model.Season;
import br.alura.streammatch.model.Serie;
import br.alura.streammatch.service.DataProcessor;

@SpringBootApplication
public class StreammatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreammatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try{
			var processor = new DataProcessor();

			var serieUrl = "https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c";
			var serieResult = processor.process(serieUrl, Serie.class);
			System.out.println(serieResult);

			var episodeUrl = "https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=6585022c";
			var episodeResult = processor.process(episodeUrl, Episode.class);
			System.out.println(episodeResult);

			var seasonUrl = "https://www.omdbapi.com/?t=gilmore+girls&season=1&apikey=6585022c";
			var seasonResult = processor.process(seasonUrl, Season.class);
			System.out.println("Season: " + seasonResult.season());
			seasonResult.episodes().forEach(System.out::println);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
