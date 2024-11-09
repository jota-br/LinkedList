package linked.pkg;

public class Item implements Comparable<Item> {

    private final int value;
    private Item previous;
    private Item next;

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Item getPrevious() {
        return previous;
    }

    public void setPrevious(Item previous) {
        this.previous = previous;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(this.value, o.value);
    }
}
