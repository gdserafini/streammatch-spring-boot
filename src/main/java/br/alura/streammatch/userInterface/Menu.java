package br.alura.streammatch.userInterface;

import java.io.IOException;

import br.alura.streammatch.model.Episode;
import br.alura.streammatch.model.Season;
import br.alura.streammatch.model.Serie;
import br.alura.streammatch.service.DataProcessor;

public class Menu {
    private DataProcessor processor = new DataProcessor();
    private URLComposer urlComposer = new URLComposer(); 
    private MenuReader reader = new MenuReader();
    private int actualTempSeason;
    
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
            actualTempSeason = i+1;

            //seasonResult.episodes().forEach(episode -> {
            //    var completeEpisode = episode.withSeason(
            //        episode.title(), episode.episode(), this.actualTempSeason
            //    );
            //    System.out.println(completeEpisode);
            //});

            seasonResult.episodes()
                .stream()
                .map(episode -> processEpisode(episode))
                .map(episode -> episode.toString().toUpperCase())
                .forEach(System.out::println);
        }
    }

    private Episode processEpisode(Episode episode){
        return episode.withSeason(
            episode.title(), episode.episode(), this.actualTempSeason
        );
    }
}
