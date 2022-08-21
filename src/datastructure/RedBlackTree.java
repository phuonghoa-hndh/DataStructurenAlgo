package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private class Node{
        private Key key;
        private Value value;
        private boolean red;
        private int count;
        private Node left, right;

        public Node(Key key, Value value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.red = isRed;
            this.count = 1;
            this.left = this.right = null;
        }
    }

    private Node root;
    private BTreePrinter printer = new BTreePrinter();

    private boolean isRed(Node node) {
        if (node == null)
            return false;

        return node.red;
    }

    private Node leftRotation(Node node) {
        assert(isRed(node.right));
        Node r = node.right;
        node.right = r.left;
        r.left = node;
        r.red = node.red;
        node.red = true;
        return r;
    }

    private Node rightRotation(Node node) {
        assert(isRed(node.left));
        Node l = node.left;
        node.left = l.right;
        l.right = node;
        l.red = node.red;
        node.red = true;

        return l;
    }

    private void flipColors(Node node) {
        assert(!isRed(node));
        assert(!isRed(node.left));
        assert(!isRed(node.right));
        node.red = true;
        node.left.red = false;
        node.right.red = false;
    }

    public Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, true);
        }
        else {
            int c = key.compareTo(node.key);
            if (c == 0) {
                node.value = value;
            }
            else {
                if (c < 0)
                    node.left = put(node.left, key, value);
                else
                    node.right = put(node.right, key, value);
            }
        }
        if (!isRed(node.left) && isRed(node.right))
            node = leftRotation(node);
        if (!isRed(node.left) && isRed(node.right))
            node = rightRotation(node);
        if (!isRed(node.left) && isRed(node.right))
            flipColors(node);
        return node;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    public void display() {
        printer.printNode(root);
    }

    class BTreePrinter {


        public void printNode(Node root) {
            int maxLevel = maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            printWhitespaces(firstSpaces);

            List<Node> newNodes = new ArrayList<Node>();
            for (Node node : nodes) {
                if (node != null) {
                    // if(node.left !=null && node.left.red)
                    //     System.out.print(" ");
                    System.out.print(node.key);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        if(nodes.get(j).left.red)
                            System.out.print("//");
                        else
                            System.out.print("/");
                    else
                        printWhitespaces(1);

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        if(nodes.get(j).right.red)
                            System.out.print("\\\\");
                        else
                            System.out.print("\\");
                    else
                        printWhitespaces(1);

                    printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private  void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private  int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
        }

        private  boolean isAllElementsNull(List<Node> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }

    public static void main(String[] args) {
        int[] key = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String[] values = {"A","B","C","D","E","D","E", "F","G", "H", "I", "J", "K"};
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int t = r.nextInt(100);
            tree.put(t, i + "");
            tree.display();
        }
    }

}

