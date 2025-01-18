package br.alura.streammatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record SerieData(
    @JsonAlias("Title") String title, 
    @JsonAlias("totalSeasons") Integer totalSeasons, 
    @JsonAlias("imdbRating") String rating
) {}
