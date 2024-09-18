package Hw5;
import java.util.Scanner;

public class testPriorityQueue {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Select:");
            System.out.println("1. UnsortedLinkPriorityQueue");
            System.out.println("2. SortedLinkPriorityQueue");
            System.out.println("3. SortedArrayPriorityQueue");
            System.out.println("4. UnsortedArrayPriorityQueue");

            int choice = sc.nextInt();
            System.out.print("Choose: ");

            System.out.println("Enter the number of elements: ");
            int n = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    UnsortedLinkedPriorityQueue<Integer, Integer> int_ulpq = new UnsortedLinkedPriorityQueue<>();

                    System.out.println("Enter integer elements (key and value): ");
                    for (int i = 0; i < n; i++) {
                        int key = sc.nextInt();
                        int value = sc.nextInt();
                        int_ulpq.insert(key, value);
                    }

                    System.out.println("Integer priority queue:");
                    while (!int_ulpq.isEmpty()) {
                        Entry<Integer, Integer> entry = int_ulpq.removeMin();
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    }

                    UnsortedLinkedPriorityQueue<String, Integer> obj_uspq = new UnsortedLinkedPriorityQueue<>();
                    System.out.println("Enter product name and price: ");
                    for (int i = 0; i < n; i++) {
                        String productName = sc.next(); //key
                        int price = sc.nextInt(); //value
                        obj_uspq.insert(productName, price);
                    }

                    System.out.println("Object priority queue (products):");
                    while (!obj_uspq.isEmpty()) {
                        Entry<String, Integer> entry = obj_uspq.removeMin();
                        System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
                    }

                    break;
                case 2:
                    SortedLinkPriorityQueue<Integer, Integer> int_slpq = new SortedLinkPriorityQueue<>();

                    System.out.println("Enter integer elements (key and value): ");
                    for (int i = 0; i < n; i++) {
                        int key = sc.nextInt();
                        int value = sc.nextInt();
                        int_slpq.insert(key, value);
                    }

                    System.out.println("Integer priority queue:");
                    while (!int_slpq.isEmpty()) {
                        Entry<Integer, Integer> entry = int_slpq.removeMin();
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    }

                    SortedLinkPriorityQueue<String, Integer> obj_slpq = new SortedLinkPriorityQueue<>();
                    System.out.println("Enter product name and price: ");
                    for (int i = 0; i < n; i++) {
                        String productName = sc.next(); //key
                        int price = sc.nextInt(); //value
                        obj_slpq.insert(productName, price);
                    }

                    System.out.println("Object priority queue (products):");
                    while (!obj_slpq.isEmpty()) {
                        Entry<String, Integer> entry = obj_slpq.removeMin();
                        System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
                    }

                    break;

                case 3:
                    UnsortedArrayPriorityQueue<Integer, Integer> int_uapq = new UnsortedArrayPriorityQueue<>();
                    System.out.println("Enter integer elements (key and value): ");
                    for (int i = 0; i < n; i++) {
                        int key = sc.nextInt();
                        int value = sc.nextInt();
                        int_uapq.insert(key, value);
                    }

                    System.out.println("Integer priority queue:");
                    while (!int_uapq.isEmpty()) {
                        Entry<Integer, Integer> entry = int_uapq.removeMin();
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    }

                    UnsortedArrayPriorityQueue<String, Integer> obj_uapq = new UnsortedArrayPriorityQueue<>();
                    System.out.println("Enter product name and price: ");
                    for (int i = 0; i < n; i++) {
                        String productName = sc.next(); //key
                        int price = sc.nextInt(); //value
                        obj_uapq.insert(productName, price);
                    }

                    System.out.println("Object priority queue (products):");
                    while (!obj_uapq.isEmpty()) {
                        Entry<String, Integer> entry = obj_uapq.removeMin();
                        System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
                    }
                    break;
                case 4:
                    SortedArrayPriorityQueue<Integer, Integer> int_sapq = new SortedArrayPriorityQueue<>();
                    System.out.println("Enter integer elements (key and value): ");
                    for (int i = 0; i < n; i++) {
                        int key = sc.nextInt();
                        int value = sc.nextInt();
                        int_sapq.insert(key, value);
                    }

                    System.out.println("Integer priority queue:");
                    while (!int_sapq.isEmpty()) {
                        Entry<Integer, Integer> entry = int_sapq.removeMin();
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    }

                    SortedArrayPriorityQueue<String, Integer> obj_sapq = new SortedArrayPriorityQueue<>();
                    System.out.println("Enter product name and price: ");
                    for (int i = 0; i < n; i++) {
                        String productName = sc.next(); //key
                        int price = sc.nextInt(); //value
                        obj_sapq.insert(productName, price);
                    }

                    System.out.println("Object priority queue (products):");
                    while (!obj_sapq.isEmpty()) {
                        Entry<String, Integer> entry = obj_sapq.removeMin();
                        System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
                    }
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }

}

