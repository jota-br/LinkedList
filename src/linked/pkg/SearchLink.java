package linked.pkg;

public class SearchLink implements LinkedItemList {

    static Item head = null;

    @Override
    public void addItem(Item newItem) {

        if (head == null) {

            head = newItem;
            return;
        }

        Item currentItem = head;
        while (currentItem != null) {
            int compare = newItem.compareTo(currentItem);

            if (compare < 0) {

                if (currentItem.getPrevious() != null) {

                    newItem.setPrevious(currentItem.getPrevious());
                    newItem.setNext(currentItem);
                    currentItem.getPrevious().setNext(newItem);
                    currentItem.setPrevious(newItem);
                } else {

                    newItem.setNext(currentItem);
                    head = newItem;
                    currentItem.setPrevious(newItem);
                }
                break;
            } else if (compare > 0) {

                if (currentItem.getNext() != null) {

                    currentItem = currentItem.getNext();

                } else {

                    newItem.setPrevious(currentItem);
                    currentItem.setNext(newItem);
                    break;
                }
            } else {
                break;
            }
        }
    }

    @Override
    public void removeItem(Item removeItem) {

        Item currentItem = head;
        while (currentItem != null) {

            int compare = removeItem.compareTo(currentItem);

            if (compare == 0) {

                if (currentItem == head) {

                    head = currentItem.getNext();
                } else {

                    currentItem.getPrevious().setNext(currentItem.getNext());
                    if (currentItem.getNext() != null) {

                        currentItem.getNext().setPrevious(currentItem.getPrevious());
                    }
                }
                break;
            } else if (compare > 0) {

                currentItem = currentItem.getNext();
            } else {
                break;
            }
        }
    }

    @Override
    public void printList() {

        System.out.println("-".repeat(30));
        System.out.printf("Head -> %s%n", head.getValue());

        Item currentItem = head;
        int index = 0;
        while (currentItem != null) {
            if (currentItem != head) {
                System.out.printf("[%d] -> %s%n", index, currentItem.getValue());
            }
            index++;
            currentItem = currentItem.getNext();
        }
        System.out.println("-".repeat(30));
    }
}
