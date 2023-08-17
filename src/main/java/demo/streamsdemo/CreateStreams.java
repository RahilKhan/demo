package demo.streamsdemo;

import demo.model.Movies;
import demo.utils.MovieUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreams {
   public static String filePath = " C:\\Users\\Rahil_Khan\\Documents\\projectWorkspace\\personal\\IdeaProjects\\practice\\src\\main\\java\\demo\\model\\Movies.txt";

    public static void main(String...args){
        testEmptyStreams();
        testStreamsFromValues();
        testCollectionsStreams();
        testInfiniteStreams();
        testFileStreams();
    }

    //From collections
    public static void testCollectionsStreams(){
        List<Movies> moviesList = MovieUtils.getMovies();
        moviesList.stream().forEach(System.out::println);
   }

    //Empty Stream
    public static void testEmptyStreams(){
        Stream<Movies> emptyStream = Stream.empty();
        System.out.println("emptyStream : " + emptyStream.count() );
    }

    //From values/arrays
    public static void testStreamsFromValues(){
        Stream<String> moviesStream = Stream.of("Jaws", "God must be crazy");
        System.out.println("moviesStream : " + moviesStream.count() );

        String[] moviesArr = {"Jaws", "God must be crazy","JP"};
        Stream<String> moviesStream1 = Stream.of(moviesArr);
        System.out.println("moviesStream1 : " + moviesStream1.count() );
    }

    //Infinite Stream
    public static void testInfiniteStreams(){
        Stream<Double> dblStream = Stream.generate(Math::random);
//        dblStream.forEach(System.out::println);


    }

    /**
     * Just the way collections API was enhanced with the stream functionality, there are other APIs as well in Java that have been enhanced to produce streams too.
     * For example, files class has been enhanced with a new method called stream that produces a stream of string values.
     * Let's see an example how we can use files method to produce stream.
     * We are using lines method on the files class, which, as you can see, the API says that it produces a stream of strings.
     * Let's execute this function and see if it can print out whatever the contents in this particular file to the console by using streams.forEach.
     * Let's suppress this one. So this is what is in the file.
     * So you can see that we have provided a streams functionality on the files to produce a stream of lines.
     * So in this lesson, we have created new streams from data structures like collections or arrays, and also generating an infinite stream.
     * */
    //File Stream
    public static void testFileStreams(){
    }
}
