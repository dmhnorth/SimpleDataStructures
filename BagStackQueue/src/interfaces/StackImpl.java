package interfaces;

import java.util.Iterator;

public class StackImpl<Item> implements Stack<Item> {
    private Node head = null;

    @Override
    public void push(Item item) {
        Node node = new Node(item);

        if(isEmpty()){
            head = node;
        }

    }

    @Override
    public Item pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
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
