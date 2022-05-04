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

     //Добавляет элемент в начало списка
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

    //Добавляет элемент в конец списка
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

    //Берет элемент из начала списка без его удаления
    public T getElementFromHead() {
        if (this.size != 0)
            return head.element;
        return null;
    }

    //Берет элемент из начала списка и удаляет его из списка
    public T peekElementFromHead() {
        if (this.size != 0) {
            T tmp = getElementFromHead();
            head = head.next;
            --size;
            return tmp;
        }
        return null;
    }

    //Берет элемент из хвоста списка без его удаления
    public T getElementFromEnd() {
        if (this.size != 0)
            return tail.element;
        return null;
    }

    //Берет элемент из хвоста списка и удаляет его из списка
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

    //Опеределяет является ли список пустым
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Опеределяет содержит ли список элемент
    public boolean contains(T data) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.element.equals(data))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    //Выводит элементы списка на экран
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

    //Узел списка
    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
