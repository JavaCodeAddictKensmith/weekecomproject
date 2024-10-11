package ecomstore;

import java.util.Scanner;

public class AddProductToCart  implements  IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Product product = new Product();

        Cart cart = new Cart();
        System.out.println("\nEnter product id: ");
        int productId = s.nextInt();
//        System.out.println("\nEnter product name: ");
//        String name = s.next();
        if( database.getProductId(productId) == -1){
            System.out.println("There is no product with this name or id!\n");
            user.menu(database,user);
            return;
        }else{

//            product.setId(productId);
//            product.setName(name);
//            System.out.println("Enter product category Id: ");
//            product.setCat_id(s.nextInt());
//            System.out.println("Enter product quantity: ");
//            product.setQty(s.nextInt());
//            System.out.println("Enter product price ");
//            product.setPrice(s.next());
//            System.out.println("like product, enter one to like, enter zero if you wish continue");
//            product.setLikes(s.nextInt());
//            pstm.setInt(1,product.getId());
//            pstm.setInt(2,product.getCat_id());
//            pstm.setInt(3,product.getId());
//            pstm.setString(4,product.getName());
//            pstm.setInt(5,product.getQty());
//            pstm.setString(6,product.getPrice());
//            pstm.setInt(7,product.getLikes());
            cart.setId(product.getId());
            cart.setCategory_id(product.getCat_id());
            cart.setProduct_id(product.getId());
            cart.setName(product.getName());
            cart.setQty(product.getQty());
            cart.setPrice(product.getPrice());
            cart.setLikes(product.getLikes());
            database.AddProductToCart(productId);

            user.menu(database, user);
            s.close();

        }

    }
}
