package example;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String...args){
        List list = new ArrayList<>();
        list.add(1);
        list.add("one");
        list.add(0.0);
        list.add(1L);

        System.out.println("list : " + list);

        for(Object obj: list){
            System.out.println("obj : " + obj);
        }
    }
}

