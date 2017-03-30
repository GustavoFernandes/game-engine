package com.github.gustavofernandes.gameengine.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CircularSinglyLinkedListTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void regularCircularListTest() {
        String[] arr = {"a", "b", "c"};
        CircularSinglyLinkedList<String> list = new CircularSinglyLinkedList<>(arr);
        String out = "";

        for (int i = 0; i < 10; i++) {
            String s = list.next();
            System.out.println(i + " " + s);
            out += s;
        }

        assertEquals("abcabcabca", out);
    }

    @Test
    public void emptyCircularListTest() {
        this.thrown.expect(NullPointerException.class);

        String[] arr = {};
        CircularSinglyLinkedList<String> list = new CircularSinglyLinkedList<>(arr);
        list.next(); // null pointer exception
        fail();
    }

    @Test
    public void singleElementCircularListTest() {
        String[] arr = {"a"};
        CircularSinglyLinkedList<String> list = new CircularSinglyLinkedList<>(arr);
        String out = "";

        for (int i = 0; i < 10; i++) {
            String s = list.next();
            System.out.println(i + " " + s);
            out += s;
        }

        assertEquals("aaaaaaaaaa", out);
    }
}
