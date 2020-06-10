package sdflower80.study.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sdflower
 * @since 10/06/2020 14:07
 */
public class OptionalTest {
    public static void main(String[] args) {

        Item item = new Item();
        item.setId(1L);

        List<Item> items = new ArrayList<>();
        items.add(item);

        Bundle bundle = new Bundle();
        bundle.setItems(items);
        List<Bundle> bundles = new ArrayList<>();
        bundles.add(bundle);

        Order order = new Order();
        order.setBundles(bundles);
        Optional<Order> o = Optional.of(order);
        Optional<Item> item1 = o.map(o1 -> {
            return o1.getBundles().stream()
                    .flatMap(b -> b.getItems().stream())
                    .filter(it -> it.getId().equals(1L))
                    .findAny()
                    .orElse(null);
        });

        System.out.println(item1.get());
    }

    static class Order {
        private List<Bundle> bundles;

        public List<Bundle> getBundles() {
            return bundles;
        }

        public void setBundles(List<Bundle> bundles) {
            this.bundles = bundles;
        }
    }

    static class Bundle {
        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "Bundle{" +
                    "items=" + items +
                    '}';
        }
    }

    static class Item {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    '}';
        }
    }
}
