public interface Communication {
    default double costOfItem(Item item) {
        return item.getCost();
    }

    default void isItemsInStorage(Seller seller, Consumer consumer) {
        for (Item item : consumer.wishList.keySet()) {
            if (seller.items.containsKey(item)) {
                if (seller.items.get(item) < consumer.wishList.get(item)) {
                    System.out.println("У нас нe хватает " + item.getNameOfItem() + " продадим " + seller.items.get(item));
                    consumer.wishList.put(item, consumer.wishList.get(item) - seller.items.get(item));
                    consumer.addCorrectList(item, seller.items.get(item));
                } else {
                    consumer.addCorrectList(item, consumer.wishList.get(item));
                    consumer.wishList.remove(item);
                }
            } else {
                System.out.println("У нас нет " + item.getNameOfItem());
            }
        }
    }

    default double totalCost(Consumer consumer) {
        double total = 0;
        while (consumer.hasNext()) {
            total += consumer.next().getCost();
        }
        return total;
    }

    default void areYouPoor(Consumer consumer) throws InterruptedException {
        if (totalCost(consumer) > consumer.getMoney()) {
            System.out.println("Ты нищеброд");
        } else {
            walkInStorage(consumer);
        }
    }

    void walkInStorage(Consumer consumer) throws InterruptedException;
}
