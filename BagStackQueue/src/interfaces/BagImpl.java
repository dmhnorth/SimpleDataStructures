package interfaces;

import java.util.Iterator;

public class BagImpl<Item> implements Bag<Item> {

    private Node head = null;

    @Override
    public void add(Item i) {
        Node newNode = new Node(i);

        if (isEmpty()){
            head = newNode;
        } else {
            newNode.next = head;
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
            while(current.next != null){
                count++;
                current = current.next;
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
