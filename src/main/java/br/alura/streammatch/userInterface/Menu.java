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
    
    public void run() throws IOException, InterruptedException{
        var serieName = reader.readSerieName();
        var serieCompleteUrl = urlComposer.getSerieUrl(serieName);
        var serieResult = processor.process(serieCompleteUrl, Serie.class);
        System.out.println(serieResult);

        var seasonNumber = reader.readSeasonNumber();
        var seasonCompleteUrl = urlComposer.getSeasonUrl(serieName, seasonNumber);
        var seasonResult = processor.process(seasonCompleteUrl, Season.class);
        System.out.println(seasonResult);

        var episodeNumber = reader.readSeasonNumber();
        var episodeCompleteUrl = urlComposer.getEpisodeUrl(serieName, seasonNumber, episodeNumber);
        var episodeResult = processor.process(episodeCompleteUrl, Episode.class);
        System.out.println(episodeResult);
    }
}
