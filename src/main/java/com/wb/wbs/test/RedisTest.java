package com.wb.wbs.test;

import java.util.StringJoiner;

/**
 * Redis Test
 */
public class RedisTest {
    /**
     * redis详解
     */

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("hello");
        joiner.add("world");
        System.out.println(joiner.toString());
    }
}
