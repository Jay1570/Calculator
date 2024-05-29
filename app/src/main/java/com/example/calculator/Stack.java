package com.example.calculator;

public class Stack<E> {

    private Object[] elements;
    private int top;

    public Stack() {
        elements = new Object[10];
        top = -1;
    }

    public void push(E d) {
        top++;
        if (top == elements.length) {
            resize();
        }
        elements[top] = d;
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object d = elements[top];
        top--;
        return d;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        Object[] temp = new Object[top * 2];
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    public Object getTop() {
        return elements[top];
    }

    int priority(char d) {
        switch (d) {
            case '*', '/' -> {
                return 2;
            }
            case '+', '-' -> {
                return 1;
            }
            default -> {
                return 0;
            }
        }
    }
}