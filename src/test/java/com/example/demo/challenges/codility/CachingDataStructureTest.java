package com.example.demo.challenges.codility;

import com.example.demo.service.GreetingService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CachingDataStructureTest {

    private CachingDataStructure cachingDataStructure;
    private HashMap<String, String> dataTestMap;
    private
    @Mock
    TimeProvider timeProvider;
    private static final int MAX_SIZE = 10;
    List<String> keyList;
    List<String> valueList;
    List<Long> ttlList;

    @BeforeEach
    void init() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
        ttlList = new ArrayList<>();
//        keyList.add("testKey");
//        valueList.add("testValue");
//        ttlList.add(10000L);
//
//        keyList.add("test");
//        valueList.add("value");
//        ttlList.add(-1L);

        keyList.add(null);
        valueList.add("test");
        ttlList.add(1000L);
        keyList.add("testKey");
        valueList.add("testValue");
        ttlList.add(10000L);
        keyList.add("testKey1");
        valueList.add("willBeEvicted");
        ttlList.add(10000L);
        keyList.add("testKey1");
        valueList.add("willRemain");
        ttlList.add(10000L);
        keyList.add("test");
        valueList.add("value");
        ttlList.add(0L);
        keyList.add("test");
        valueList.add("null");
        ttlList.add(1000L);
        keyList.add("testKey1");
        valueList.add("evicted");
        ttlList.add(10000L);
        keyList.add("testKey1");
        valueList.add("willBeEvicted");
        ttlList.add(10000L);
        keyList.add("testKey");
        valueList.add("testValue");
        ttlList.add(10000L);
        keyList.add("testKey");
        valueList.add("testValue");
        ttlList.add(10000L);
        keyList.add("testKey1");
        valueList.add("willRemain");
        ttlList.add(10000L);
    }

    @Test
    public void shouldReplaceElementWithTheSameKeyAndSmallerTTL() {
        when(timeProvider.getMillis()).thenReturn(10L);
        cachingDataStructure = new CachingDataStructure(timeProvider, MAX_SIZE);
        String key = "testKey";
        String value = "testValue";
        long ttl = 10000L;
        cachingDataStructure.put(key, value, ttl);

        key = "testKey";
        value = "testValue";
        ttl = 1000L;
        cachingDataStructure.put(key, value, ttl);
        Optional<String> valueOptional = cachingDataStructure.get(key);
        assertEquals(value, valueOptional.get());
    }

    @Test
    public void shouldNotAcceptNegativeTimeToLeave() {
        when(timeProvider.getMillis()).thenReturn(10L);
        String key = "test";
        String value = "value";
        long ttl = -1L;

        cachingDataStructure = new CachingDataStructure(timeProvider, MAX_SIZE);
//        cachingDataStructure.put(key, value, ttl);
//        assertThrows(IllegalArgumentException());
        assertThrows(IllegalArgumentException.class, () -> cachingDataStructure.put(key, value, ttl));
//        assertEquals("Mock user name", testName);

    }

}
