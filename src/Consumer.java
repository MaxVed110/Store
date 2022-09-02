import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Consumer extends Human implements Iterator<Item> {
    Map<Item, Integer> wishList = new HashMap<>();
    private int index;
    private ArrayList<Item> correctList = new ArrayList<>();

    public Consumer(String name, double money, int loveIndex) {
        super(name, money, loveIndex);
        this.index = 0;
    }

    public void addWishList(Item item, Integer count) {
        if (this.wishList.containsKey(item)) {
            this.wishList.put(item, this.wishList.get(item) + count);
        } else {
            this.wishList.put(item, count);
        }
    }

    //public ArrayList<Item> getCorrectList() {
    //    return this.correctList;
    //}

    public void addCorrectList(Item item, int count) {
        for (int i = 0; i < count; i++) {
            correctList.add(item);
        }
    }

    @Override
    public void walkInStorage(Consumer consumer) {
        System.out.println("Покупатель получил товар, списки обновлены!");
        consumer.correctList.clear();
    }

    @Override
    public boolean hasNext() {
        return index < this.correctList.size();
    }

    @Override
    public Item next() {
        return this.correctList.get(index++);
    }
}
