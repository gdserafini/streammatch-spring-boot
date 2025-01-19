package br.alura.streammatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Season(
    @JsonAlias("Season") Integer season,
    @JsonAlias("Episodes") List<Episode> episodes
) implements IData { }
