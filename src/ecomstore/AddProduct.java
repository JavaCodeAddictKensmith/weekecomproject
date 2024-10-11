package ecomstore;

import java.util.Scanner;

public class AddProduct implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Product product = new Product();
        System.out.println("\nEnter product id: ");
        int productId = s.nextInt();
        System.out.println("\nEnter product name: ");
        String name = s.next();
        if(database.getProduct(name)>-1 || database.getProductId(productId) == -1){
            System.out.println("There is a product with this name or id!\n");
            user.menu(database,user);
            return;
        }else{
            product.setId(productId);
           product.setName(name);
            System.out.println("Enter product category Id: ");
           product.setCat_id(s.nextInt());
            System.out.println("Enter product quantity: ");
           product.setQty(s.nextInt());
            System.out.println("Enter product price ");
          product.setPrice(s.next());
            System.out.println("like product, enter one to like, enter zero if you wish continue");
            product.setLikes(s.nextInt());
           database.AddProduct(product);

           user.menu(database, user);
           s.close();

        }




    }
}
