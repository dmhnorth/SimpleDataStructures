package interfaces;

import java.util.Iterator;

public class BagImpl<Item> implements Bag<Item> {

    private int size = 0;
    private Node head = null;

    @Override
    public void add(Item i) {
        Node newNode = new Node(i);

        if (isEmpty()){
            head = newNode;
        } else {
            head.next = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public Item next() {
                Item item = currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }

    class Node{
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }
}
