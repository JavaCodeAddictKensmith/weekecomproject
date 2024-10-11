package ecomstore;

import java.util.Scanner;

public class UpdateProduct implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Product product = new Product();
        System.out.println("\nEnter product id: ");
        int productId = s.nextInt();

        if(database.getProductId(productId) == -1){
            System.out.println("There is no  product with this id!\n");
            user.menu(database,user);
            return;
        }else{

            System.out.println("Enter product category Id: ");
            int catid =s.nextInt();
            if(database.getCategoryId(catid)== -1){
                System.out.println("There is no category with this id!\n");
                user.menu(database,user);
                return;

            }else {
                System.out.println("\nEnter product name: ");
                String name = s.next();



//                product.setCat_id(catid);


//                product.setId(productId);
//                product.setName(name);
                System.out.println("Enter product quantity: ");
                int qty = s.nextInt();
//                product.setQty(s.nextInt());
                System.out.println("Enter product price ");
                String price = s.next();
//                product.setPrice(s.next());
                System.out.println("like product, enter one to like, enter zero if you wish continue");
                int like = s.nextInt();
//                product.setLikes(s.nextInt());
                database.updateProduct(productId,catid,name,qty,price,like);

                user.menu(database, user);
                s.close();

            }



        }

    }
}
