package interfaces;

import java.util.Iterator;

public class BagImpl<Item> implements Bag<Item> {

    private Node head = null;

    @Override
    public void add(Item item) {
        Node newNode = new Node(item);

        if (isEmpty()){
            head = newNode;
        } else {
            newNode.linkedNode = head;
            head = newNode;
        }
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

    private class Node{
        private Item item;
        private Node linkedNode;

        Node(Item item) {
            this.item = item;
        }
    }
}