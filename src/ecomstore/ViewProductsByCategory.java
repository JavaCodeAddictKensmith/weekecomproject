package ecomstore;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewProductsByCategory implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nEnter product cate_id to view details: ");
        int catid = s.nextInt();
// if(n != -1){
        if(database.getCategoryId(catid)!= -1){
            database.getProductsByCategory(catid);
            user.menu(database, user);
            s.close();

        }else {
            System.out.println("There is no product with this cat_id!\n");
            user.menu(database,user);
            return;
        }
        System.out.println();
        user.menu(database,user);

    }
}
