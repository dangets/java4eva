package com.dangets.thebasics;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class TheBasicsJ {
    public static void main(String[] args) {
        var x = 10;
        final var y = "foobar";


        final String greeting = "Hello";
        String who = "World";
        if (args.length > 0)
            who = args[0];
        System.out.println(greeting + ", " + who);
    }



    void doodle() {
        var x = ImmutableMap.of();
        var m = ImmutableMap.of("up", "down");
        poodle(m);

        paddle(m);
        paddle(Map.of("cat", "dog"));
    }

    void poodle(ImmutableMap<String, String> a) {
        // ...
    }

    // Immutable
    // No modifier methods
    //   (put, clear, ...)

    void paddle(Map<String, String> b) {
        b.put("yes", "no");
    }

    class User {
        private final int id;
        private final String name;
        private Integer age;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // getId()
        // getName()
        // get/setAge()

        // toString
        // hashCode/equals?
    }
}
