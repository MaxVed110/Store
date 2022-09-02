import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Seller extends Human {
    //товар и его количество
    Map<Item, Integer> items = new HashMap<>();

    public Seller(String name, double money, int loveIndex) {
        super(name, money, loveIndex);
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    @Override
    public void walkInStorage(Consumer consumer) throws InterruptedException {
        System.out.println("Иду на склад...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Выдаю товар...");
        TimeUnit.SECONDS.sleep(2);
        while (consumer.hasNext()) {
            Item buf = consumer.next();
            items.put(buf, items.get(buf) - 1);
            if (items.get(buf) == 0 || items.get(buf) == null) {
                items.remove(buf);
            }
        }
        System.out.println("Товар выдан!");
    }
}
