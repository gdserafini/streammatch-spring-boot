package br.alura.streammatch.userInterface;

import java.io.IOException;
import br.alura.streammatch.model.Season;
import br.alura.streammatch.model.Serie;
import br.alura.streammatch.service.DataProcessor;

public class Menu {
    private DataProcessor processor = new DataProcessor();
    private URLComposer urlComposer = new URLComposer(); 
    private MenuReader reader = new MenuReader();
    
    public void run() throws IOException, InterruptedException{
        var serieName = reader.readSerieName();
        var serieCompleteUrl = urlComposer.getSerieUrl(serieName);
        var serieResult = processor.process(serieCompleteUrl, Serie.class);
        var numberOfSeasons = serieResult.totalSeasons();
        System.out.println(serieResult);

        for(int i = 0; i < numberOfSeasons; i++){
            var seasonCompleteUrl = urlComposer.getSeasonUrl(serieName, i+1);
            var seasonResult = processor.process(seasonCompleteUrl, Season.class);
            System.out.println("Temporada: " + seasonResult.season());

            for(int j = 0; j < seasonResult.episodes().size(); j++){
                var episode = seasonResult.episodes().get(j);
                var completeEpisode = episode.withSeason(
                    episode.title(), episode.episode(), i+1
                );
                System.out.println(completeEpisode);
            };
        }
    }
}
