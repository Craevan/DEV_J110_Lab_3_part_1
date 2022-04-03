package ru.avalon.jdev_110;


public class CustomSingleLinkedList<T> {

    private int size;

    private Node<T> head;
    private Node<T> tail;

    public CustomSingleLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Добавляет элемент в начало списка
     */
    public void addToHead(T data) {
        if (this.size == 0) {
            addFirstElement(data);
        }
        else {
            Node<T> tmp = head;
            tmp.next = head.next;
            head = new Node<>(data);
            head.next = tmp;
        }
        ++size;
    }

    public void addToEnd(T data) {
        if (this.size == 0) {
            addFirstElement(data);
        }
        else {
            Node<T> tmp = tail;
            tail = new Node<>(data);
            tmp.next = tail;

        }
        ++size;
    }

    public T getElementFromHead() {
        if (this.size != 0)
            return head.element;
        return null;
    }

    public T peekElementFromHead() {
        if (this.size != 0) {
            T tmp = getElementFromHead();
            head = head.next;
            --size;
            return tmp;
        }
        return null;
    }

    public T getElementFromEnd() {
        if (this.size != 0)
            return tail.element;
        return null;
    }

    public T peekElementFromEnd() {
        if (this.size != 0) {
            T tmp = getElementFromEnd();
            Node<T> tmpNode = head;
            while (tmpNode != null) {
                if (tmpNode.next == tail) {
                    tail = tmpNode;
                    tail.next = null;
                }
                tmpNode = tmpNode.next;
            }
            --size;
            return tmp;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(T data) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.element.equals(data))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public void printAll() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    private void addFirstElement(T data) {
        this.head = new Node<>(data);
        this.tail = head;
        this.head.next = null;
    }

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}