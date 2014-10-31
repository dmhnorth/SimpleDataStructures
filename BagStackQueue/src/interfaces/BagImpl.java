package interfaces;

import java.util.Iterator;

public class BagImpl<Item> implements Bag<Item> {
    @Override
    public void add(Object o) {

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
    public Iterator iterator() {
        return null;
    }
}
