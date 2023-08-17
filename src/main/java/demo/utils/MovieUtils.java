package demo.utils;

import demo.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class MovieUtils {

    public static List<Movies> getMovies() {
        List<Movies> moviesList = new ArrayList();
        moviesList.add(new Movies("God must be crazy", "Billy Chan", 1980));
        moviesList.add(new Movies("Jaws", "Steven Spielberg", 1975));
        moviesList.add(new Movies("Jaws", "Steven Spielberg", 1978));
        moviesList.add(new Movies("E.T", "Steven Spielberg", 1982));
        moviesList.add(new Movies("Star Wars", "George Lucas", 1977));
        moviesList.add(new Movies("Jurassic Park", "Steven Spielberg", 1993));
        moviesList.add(new Movies("Jurassic Park", "Steven Spielberg", 1997));
        moviesList.add(new Movies("Jurassic Park", "Steven Spielberg", 2001));
        moviesList.add(new Movies("Saving Private Ryan", "Steven Spielberg", 1998));
        moviesList.add(new Movies("Pulp Fiction", "Quentin Tarantino", 1994));

        return moviesList;
    }

}
