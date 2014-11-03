package interfaces;

import java.util.Iterator;

public class QueueImpl<Item> implements Queue<Item> {

    private Node head;

    @Override
    public void enqueue(Item item) {

    }

    @Override
    public Item dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
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
        private Item item;
        private Node next;

        Node(Item item) {
            this.item = item;
        }
    }
}
