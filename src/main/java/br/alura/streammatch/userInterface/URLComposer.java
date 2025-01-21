package br.alura.streammatch.userInterface;

public class URLComposer {
    private final String BASE_URL = "https://www.omdbapi.com/";
    private final String API_KEY = "6585022c";

    public String getSerieUrl(String serieName){
        return BASE_URL + "?t=" + serieName.replace(" ", "-") + "&apikey=" + API_KEY;
    }

    public String getEpisodeUrl(
            String serieName, Integer season, Integer episode){
        return BASE_URL + 
            "?t=" + serieName.replace(" ", "-") + 
            "&season=" + season + 
            "&episode=" + episode + 
            "&apikey=" + API_KEY;
    }

    public String getSeasonUrl(String serieName, Integer season){
        return BASE_URL + 
            "?t=" + serieName.replace(" ", "-") + 
            "&season=" + season + 
            "&apikey=" + API_KEY;
    }
}
