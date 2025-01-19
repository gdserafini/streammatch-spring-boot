package br.alura.streammatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.alura.streammatch.model.SerieData;
import br.alura.streammatch.service.APIConsumer;
import br.alura.streammatch.service.DataConverter;

@SpringBootApplication
public class StreammatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreammatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		var consumer = new APIConsumer();
		var converter = new DataConverter();
		try{
			var json = consumer.getData(
				"https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
			);
			var data = converter.mapData(json, SerieData.class);
			System.out.println(data);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
