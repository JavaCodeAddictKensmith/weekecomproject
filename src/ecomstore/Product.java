package ecomstore;

public class Product {

    private  int id;
    private int cat_id;
    private String name;
    private int qty;
    private String price;
    private int likes;



   	//Copies for borrowing

    public Product() {};

    public Product(int id,int cat_id,String name,
                  int qty, String price,  int likes ) {
        this.id=id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.cat_id = cat_id;
        this.likes = likes;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cat_id=" + cat_id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price='" + price + '\'' +
                ", likes=" + likes +
                '}';
    }

public int getId() {
    return id;
}

    public void setId(int id) {
        this.id = id;
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

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }




//    public String toString2() {
//        String text = name+"<N/>"+author+"<N/>"+publisher+"<N/>"+adress+"<N/>"+String.valueOf(qty)+
//                "<N/>"+String.valueOf(price)+"<N/>"+String.valueOf(brwcopies);
//        return text;
//    }

}
