package com.example.demo.javafeatures.basic.immutableExample;

import com.example.demo.model.dummy.DummyEmployee;
import com.example.demo.model.Address;
import com.example.demo.model.Employee;
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
        Employee employee = DummyEmployee.getDummyEmployee();


        ImmutableClass im = new ImmutableClass(100, add, hm, new Profession("Sol Architect", "TOGAF 9.2"), employee);
        log.info("immutable class : {}", im);

        /** Not possible as Profession is record type which immutable and final by default*/
        /* Profession prof = im.getProfession(); */

        /** Attempt to update HashMap in ImmutableClass
         * Expectation: should not be updated as deep clone of hashmap is returned in ImmutableClass */
        log.info("Before -> ImmutableClass.MetaMap() : {}", im.getMetaMap());
        hm.put("t3", "v3");
        HashMap hm1 = im.getMetaMap();
        hm1.put("t4", "v4");
        log.info("After  -> ImmutableClass.MetaMap() : {}", im.getMetaMap());

        /** Attempt to update dependency Address in ImmutableClass
         * Expectation:
         * Streat     : should not be updated as there is no setter method defined
         * MutableStr : should be updated as it is purposely made mutable */
        log.info("Before -> ImmutableClass.Address.MutableStr() : {}", im.getAddress().getMutableStr());
        add = im.getAddress();
        /* add.setStreat(); */
        add.setMutableStr("New Streat");
        log.info("After  -> ImmutableClass.Address.MutableStr() : {}", im.getAddress().getMutableStr());


        /** Attempt to update dependency Employee in ImmutableClass
         * Expectation:
         * Streat     : should not be updated as there is no setter method defined
         * MutableStr : should be updated as it is purposely made mutable */
        log.info("Before -> ImmutableClass.Employee().getAge() : {}, im.getEmployee().getDepartment() : {}"
                , im.getEmployee().getAge(), im.getEmployee().getDepartment());
        employee.setDepartment("Mutable");
        Employee emp = im.getEmployee();
        emp.setAge(10000);
        log.info("After  -> ImmutableClass.Employee().getAge() : {}, im.getEmployee().getDepartment() : {}"
                , im.getEmployee().getAge(), im.getEmployee().getDepartment());


    }

}
