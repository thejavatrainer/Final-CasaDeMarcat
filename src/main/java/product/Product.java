package product;

public class Product {
    private String name;
    Integer price;
    private Integer items;

    public Product(String name, Integer price, Integer items) {
        this.name = name;
        this.price = price;
        this.items = items;
    }

    @Override
    public String toString() {
        return "product.Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", items=" + items +
                '}';
    }

    public void test123() {
        Product test12 = new Product("aa", 3, 3);
        System.out.println(test12.price);
    }

    public Integer returnPrice() {
        return this.price;
    }
}


