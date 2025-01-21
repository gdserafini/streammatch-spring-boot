package br.alura.streammatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Episode(
    @JsonAlias("Title") String title,
    @JsonAlias("Episode") Integer episode,
    Integer season
) implements IData { 

    public Episode withSeason(String title, Integer episode, Integer season){
        return new Episode(title, episode, season);
    }

    @Override
    public final String toString() {
        return "Título: " + title + " - " + season + "x" + episode;
    }

}
