package interfaces;

import java.util.Iterator;

public class QueueImpl<Item> implements Queue<Item> {

    private Node head;

    @Override
    public void enqueue(Item item) {
        Node newNode = new Node(item);

        if(isEmpty()){
            head = newNode;
        } else {
            newNode.linkedNode = head;
            head = newNode;
        }
    }

    @Override
    public Item dequeue() {
        Node currentNode = head, nextInQueue = head;

        if(isEmpty()){
            return null;
        } else if(head.linkedNode == null){
            currentNode = head;
            head = null;
        }

        while(currentNode.linkedNode != null){
            nextInQueue = currentNode;
            currentNode = currentNode.linkedNode;
        }
        nextInQueue.linkedNode = null;

        return currentNode.item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        int count = 0;

        Node current = head;

        if(head != null){
            count++;
            while(current.linkedNode != null){
                count++;
                current = current.linkedNode;
            }
        }
        return count;
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
                currentNode = currentNode.linkedNode;
                return item;
            }
        };
    }

    class Node{
        private Item item;
        private Node linkedNode;

        Node(Item item) {
            this.item = item;
        }
    }
}
