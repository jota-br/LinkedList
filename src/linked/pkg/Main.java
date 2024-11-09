package linked.pkg;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SearchLink newList = new SearchLink();
        for (int i = 0; i < 25; i++) {
            newList.addItem(new Item(generateItemString()));
        }

        newList.printList();
        newList.removeItem(new Item(9));
        newList.printList();

    }

    public static int generateItemString() {

        Random random = new Random();
        return random.nextInt(1, 50);
    }
}
