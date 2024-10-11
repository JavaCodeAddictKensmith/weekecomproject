package ecomstore;

import java.util.Scanner;

public class ViewProductById implements  IOOperation {
    @Override
    public void oper(Database database, User user) {

        Scanner s = new Scanner(System.in);

        System.out.println("\nEnter product id to view details: ");
        int productId = s.nextInt();
// if(n != -1){
        if(database.getProductId(productId) != -1){
            database.getProductById(productId);
            user.menu(database, user);
            s.close();

        }else {
            System.out.println("There is no product with this id!\n");
            user.menu(database,user);
            return;
        }

    }
}
