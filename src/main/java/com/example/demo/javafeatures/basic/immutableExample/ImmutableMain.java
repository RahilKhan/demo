package com.example.demo.javafeatures.basic.immutableExample;

import com.example.demo.model.Address;
import com.example.demo.model.Profession;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class ImmutableMain {

    public static void main(String... args) {

        HashMap<String, String> hm = new HashMap<>();
        hm.put("t1", "v1");
        hm.put("t2", "v2");
        Address add = new Address("fdb rd", 122004);

        ImmutableClass im = new ImmutableClass(100, add, hm, new Profession("Sol Architect","TOGAF 9.2"));
        log.info("im : {}", im);

        hm.put("t3", "v3");
        log.info("im : {}", im);

//        Profession prof = im.getProfession();
        HashMap hm1 = im.getMetaMap();
        hm1.put("t4", "v4");
        log.info("im : {}", im);

    }
}
