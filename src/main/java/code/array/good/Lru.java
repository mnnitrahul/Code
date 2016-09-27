package code.array.good;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/least-recently-used-cache/
 */

/**
 * Created by rahul.ka on 21/09/16.
 */

public class Lru {
    class Node {

        public Node(Node left, Node right, int key, int value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
        int key;
        int value;
        Node left;
        Node right;
    }
    private final int capacity;
    private int size;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    public Lru(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveNodeToHead(node);
        System.out.println("GET head key: " + head.key + " value:" + head.value + " left: " + head.left + " right: " + head.right);
        System.out.println("GET tail key: " + tail.key + " value:" + tail.value + " left: " + tail.left + " right: " + tail.right);

        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.value = value;
            moveNodeToHead(node);
            return;
        }

        if (size == capacity) {
            Node newTail = tail.right;
            if (newTail != null) newTail.left = null;
            map.remove(tail.key);
            tail = newTail;
            size--;
        }
        size++;
        if (capacity == 1) {
            head = null;
        }
        Node newNode = new Node(head, null, key, value);
        map.put(key, newNode);
        if (head != null) head.right = newNode;
        if (head == null) {
            tail = newNode;
        }
        head = newNode;
        System.out.println("SET head key: " + head.key + " value:" + head.value + " left: " + head.left + " right: " + head.right);
        System.out.println("SET tail key: " + tail.key + " value:" + tail.value + " left: " + tail.left + " right: " + tail.right);
        return;
    }

    private void moveNodeToHead(Node node) {
        if (node == head) return;
        Node nextTail = tail;
        if (node == tail) {
            nextTail = tail.right;

        }
        if (node.left!= null) node.left.right = node.right;
        if ( node.right != null) node.right.left = node.left;
        head.right = node;
        node.left = head;
        node.right = null;
        head = node;
        tail = nextTail;
    }
}
