package demo.streamsdemo;

import demo.model.Movies;
import demo.utils.MovieUtils;

import java.util.List;
import java.util.stream.Stream;

public class LazyAndEagerOperations {

    public static void main(String...args) {
        findMoviesByDirector();
    }

    public static void findMoviesByDirector() {
        List<Movies> moviesList = MovieUtils.getMovies();
    }

}
