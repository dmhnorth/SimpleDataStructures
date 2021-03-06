package interfaces;

/**
 * LIFO policy collection
 * @param <Item>
 */
public interface Stack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
