package com.pp.collection;

import java.util.NoSuchElementException;

/**
 * Immutable Queue implementation
 *
 * @param <T>
 * @author vitthal.awate
 */
public class ImmutableQueue<T> implements Queue<T> {

    /**
     * Stack for forward ordering of queue elements
     */
    private Stack<T> forward;

    /**
     * Stack for reverse ordering of queue elements
     */
    private Stack<T> reverse;

    /**
     * Default constructor
     */
    public ImmutableQueue() {
        this.forward = new Stack<T>();
        this.reverse = new Stack<T>();
    }

    /**
     *
     * @param forward
     * @param reverse
     */
    public ImmutableQueue(Stack<T> forward, Stack<T> reverse) {
        this.forward = forward;
        this.reverse = reverse;
    }

    /**
     * Add object to queue Throws IllegalArgumentException
     * @param object
     * @return
     */
    @Override
    public Queue<T> enQueue(T object) {
        if (object != null) {
            return new ImmutableQueue<T>(this.forward.push(object), this.reverse);
        }

        throw new IllegalArgumentException();
    }

    /**
     * Assign reverse of forward to reverse to get first element in queue
     */
    private void forwardToReverse() {
        this.reverse = this.forward.reverseStack();
        this.forward = new Stack<T>();
    }

    /**
     * Remove the first element in the queue
     *
     * @return Queue
     */
    @Override
    public Queue<T> deQueue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (!this.reverse.isEmpty()) {
            return new ImmutableQueue<T>(this.forward, this.reverse.tail);
        }

        return new ImmutableQueue<T>(new Stack<T>(), this.forward.reverseStack().tail);
    }

    /**
     * Return the first element in the queue
     *
     * @return T first element
     */
    @Override
    public T head() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.reverse.isEmpty()) {
            forwardToReverse();
        }

        return this.reverse.head;
    }

    ;

    /**
     * Return the last element in the queue
     *
     * @return T last element
     */
    @Override
    public T tail() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.forward.isEmpty()) {
            return this.reverse.reverseStack().head;
        }

        return this.forward.head;
    }

    /**
     * Get queue size (equal to length of forward + reverse stack)
     *
     * @return boolean queue size
     */
    @Override
    public boolean isEmpty() {
        return this.forward.size + this.reverse.size == 0;
    }

    private static class Stack<T> {

        private T head;
        private Stack<T> tail;
        private int size;

        /**
         * Default constructor
         */
        private Stack() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /**
         * @param obj
         * @param tail
         */
        private Stack(T obj, Stack<T> tail) {
            this.head = obj;
            this.tail = tail;
            this.size = tail.size + 1;
        }

        /**
         * Check if stack is empty
         *
         * @return
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * Push new element into stack
         *
         * @param obj
         * @return
         */
        public Stack<T> push(T obj) {
            return new Stack<T>(obj, this);
        }

        /**
         * Reverse the order of the stack
         *
         * @return
         */
        public Stack<T> reverseStack() {
            Stack<T> stack = new Stack<T>();
            Stack<T> tail = this;
            while (!tail.isEmpty()) {
                stack = stack.push(tail.head);
                tail = tail.tail;
            }

            return stack;
        }
    }
}
