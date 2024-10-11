package ecomstore;

public class Cart {
      private  int id;
    private int category_id;
    private  int product_id;
    private String name;
     private int qty;
     private String price;
 private int likes;

    public Cart() {};

    public Cart(int id, int category_id, int product_id, String name, int qty, String price, int likes) {
        this.id = id;
        this.category_id = category_id;
        this.product_id = product_id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", product_id=" + product_id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price='" + price + '\'' +
                ", likes=" + likes +
                '}';
    }
}
