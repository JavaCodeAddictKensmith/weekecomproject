package ecomstore;

import java.util.Scanner;

public class RemoveProductFromCart implements  IOOperation {
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nEnter product id  to remove from cart: ");
        int productId = s.nextInt();
// if(n != -1){
        if(database.getCartId(productId) != -1){
            database.removeProductFromCart(productId);
            user.menu(database, user);
            s.close();

        }else {
            System.out.println("There is no product with this id!\n");
            user.menu(database,user);
            return;
        }



    }
}
