package ecomstore;

import java.util.Scanner;

public class Admin  extends User{

    public  Admin(String name){
        super(name);
        this.operations= new IOOperation[]{

                new AddProduct(),
                new ViewProducts(),
                new ViewProductById(),
                new UpdateProduct(),
                new DeleteProduct(),
//                new SearchProduct(),
                new Exit(),


    };
    }



/*


 this.id= id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
 */
    public Admin(int id,String name, String email, String phoneNumber,String type
    ) {
        super( name,email, phoneNumber, id,type);
        this.operations= new IOOperation[]{
                new AddProduct(),
                new ViewProducts(),
                new ViewProductById(),
                new UpdateProduct(),
                new DeleteProduct(),
//                new SearchProduct(),
                new Exit(),


        };
    }

   @Override
   public  void menu(Database database, User user){

       System.out.println("1. Add Product");
       System.out.println("2. View Products");
       System.out.println("3. View product by id");
       System.out.println("4. Update Product");
       System.out.println("5. Delete Product");
       System.out.println("6. Exit");
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       this.operations[n-1].oper(database, user);
       s.close();
   }


    public String toString() {
      return name+"<N/>" +email+"<N/>"+phoneNumber+"<N/>"+"Admin";
    }


}
