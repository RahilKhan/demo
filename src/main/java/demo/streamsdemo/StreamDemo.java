package demo.streamsdemo;

import demo.model.Movies;
import demo.model.Transactions;
import demo.utils.MovieUtils;
import demo.utils.TransactionUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamDemo {

    public static void main(String... args) {
//        getTxnForDept();
        findMoviesByDirector();
    }

    public static void getTxnForDept() {
        List<Transactions> txnList = TransactionUtils.getTransactions();

        List<Transactions> txnListIT = new ArrayList<>();

        for (Transactions txn : txnList){
            if(txn.getDept().equals("IT") && txn.getAmount() > 15000){
                txnListIT.add(txn);
            }
        }
//        System.out.println("Transaction : " + txnListIT);

        List<Transactions> txnListIT1 = txnList.parallelStream()
                .filter(txn -> txn.getDept().equals("IT"))
                .filter(txn -> txn.getAmount()>15000)
                .collect(Collectors.toList());

        System.out.println("Transaction-1 : " + txnListIT1);

    }

    public static void findMoviesByDirector() {
        List<Movies> moviesList = MovieUtils.getMovies();

        moviesList.stream()
                .filter(m->m.getDirector().equals("Steven Spielberg"))
                .map(Movies::getName)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

    }
}
