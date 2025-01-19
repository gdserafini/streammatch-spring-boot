package br.alura.streammatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Episode(
    @JsonAlias("Title") String title,
    @JsonAlias("Episode") Integer episode,
    @JsonAlias("Season") Integer season
) implements IData { }
