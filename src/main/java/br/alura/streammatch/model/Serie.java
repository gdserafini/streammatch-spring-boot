package br.alura.streammatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Serie(
    @JsonAlias("Title") String title, 
    @JsonAlias("totalSeasons") Integer totalSeasons, 
    @JsonAlias("imdbRating") String rating
) implements IData {

    @Override
    public final String toString() {
        return "Série: " + title + 
            " - Temporadas: " + totalSeasons + 
            " - Nota: " + rating;
    }

}
