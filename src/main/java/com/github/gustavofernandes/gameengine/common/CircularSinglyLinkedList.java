package com.github.gustavofernandes.gameengine.common;

public class CircularSinglyLinkedList<E> {
    // TODO maybe implement List or Collection?

    private Node<E> pointer;

    public CircularSinglyLinkedList(E[] elements) {
        if (elements.length == 0) {
            return;
        }

        Node<E> node = new Node<>(elements[0]);
        this.pointer = node; // set head
        Node<E> prev = node;

        for (int i = 1; i < elements.length; i++) {
            node = new Node<>(elements[i]);
            prev.next = node;
            prev = node;
        }

        // point last to head
        node.next = this.pointer;
    }

    /**
     * Returns the element at the pointer and advances the pointer.
     */
    public E next() {
        Node<E> node = this.pointer;
        this.pointer = this.pointer.next;
        return node.value;
    }

    private class Node<F> {
        F value;
        Node<F> next;

        Node(F value) {
            this.value = value;
        }
    }
}
