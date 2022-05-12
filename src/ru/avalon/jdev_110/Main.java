package ru.avalon.jdev_110;

public class Main {

    public static void main(String[] args) {
        CustomSingleLinkedList<String> test = new CustomSingleLinkedList<>();

        /*
            Expected output:
            true
            4
            Нулевой
            Первый
            Второй
            Третий
            false
            true
         */

        System.out.println(test.isEmpty());
        test.addToHead("Первый");
        test.addToEnd("Второй");
        test.addToEnd("Третий");
        test.addToHead("Нулевой");
        System.out.println(test.getSize());
        test.printAll();
        System.out.println(test.contains("Test"));
        System.out.println(test.contains("Третий"));

    }

}
