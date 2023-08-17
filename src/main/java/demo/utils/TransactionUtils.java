package demo.utils;

import demo.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {

    public static List<Transactions> getTransactions() {

        List<Transactions> txnList = new ArrayList<>();
        txnList.add(new Transactions(10000, "IT", 150));
        txnList.add(new Transactions(10500, "IT", 150));
        txnList.add(new Transactions(20000, "IT", 150));
        txnList.add(new Transactions(27000, "IT", 150));
        txnList.add(new Transactions(11000, "IT", 150));
        txnList.add(new Transactions(18000, "IT", 150));
        txnList.add(new Transactions(10000, "HR", 50));
        txnList.add(new Transactions(10500, "HR", 50));
        txnList.add(new Transactions(20000, "HR", 50));
        txnList.add(new Transactions(27000, "HR", 50));
        txnList.add(new Transactions(11000, "HR", 50));
        txnList.add(new Transactions(18000, "FIN", 70));
        txnList.add(new Transactions(10000, "FIN", 70));
        txnList.add(new Transactions(10500, "FIN", 70));
        txnList.add(new Transactions(20000, "FIN", 70));
        txnList.add(new Transactions(27000, "RU", 125));
        txnList.add(new Transactions(11000, "RU", 125));
        txnList.add(new Transactions(18000, "RU", 125));

        return txnList;
    }
}
