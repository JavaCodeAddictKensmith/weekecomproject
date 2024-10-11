package ecomstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Database {
    Connection con;
private ArrayList<User> users = new ArrayList<User>();
private ArrayList<String> usernames= new ArrayList<String>();
private ArrayList<Product> books = new ArrayList<Product>();
private ArrayList<String> booknames= new ArrayList<String>();
//    private ArrayList<Order> orders;
//    private ArrayList<Borrowing> borrowings;


    private File usersfile = new File("C:\\Library Management Expanded Project\\Data\\Users");  // Example absolute path
    private File booksfile = new File("C:\\Library Management Expanded Project\\Data\\Books");
    private File ordersfile = new File("C:\\Library Management Expanded Project\\Data\\Orders");// Example absolute path
    private File folder = new File("C:\\Library Management Expanded Project\\Data");
    private File borrowingsfile = new File("C:\\Library Management Expanded Project\\Data\\Borrowings");


    public Database() {
//        if (!folder.exists()) {
//            folder.mkdirs();
//        }
//        if (!usersfile.exists()) {
//            try {
//                usersfile.createNewFile();
//            } catch (Exception e) {}
//        }
//        if (!booksfile.exists()) {
//            try {
//                booksfile.createNewFile();
//            } catch (Exception e) {}
//        }
//        if (!ordersfile.exists()) {
//            try {
//                ordersfile.createNewFile();
//            } catch (Exception e) {}
//        }
//        if (!borrowingsfile.exists()) {
//            try {
//                borrowingsfile.createNewFile();
//            } catch (Exception e) {}
//        }

        users = new ArrayList<User>();
        usernames = new ArrayList<String>();
        books = new ArrayList<Product>();
        booknames = new ArrayList<String>();
//        orders = new ArrayList<Order>();
//        borrowings = new ArrayList<Borrowing>();

        getUsers();
//        getBooks();
//        getOrders();
//        getBorrowings();
    }

    public void AddUser(User s) {
        con = DBConnection.createDbConnection();
        String query ="insert into Users values(?,?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,s.getId());
            pstm.setString(2,s.getName());
            pstm.setString(3,s.getEmail());
            pstm.setString(4,s.getPhoneNumber());
            pstm.setString(5,s.getType());
            int cnt = pstm.executeUpdate();
//          System.out.println("------------------------------------");
            if(cnt!=0){
                System.out.println("User registered Successfully !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int login(String phonenumber, String email) {
      int n = -1;
//        for (User s : users) {
//            if (s.getPhoneNumber().matches(phonenumber) && s.getEmail().matches(email)) {
//                n = users.indexOf(s);
//                break;
//            }
//        }
//        return n;

        con = DBConnection.createDbConnection();
        String query = "select * from Users ";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){

                String strdbPhone =   String.valueOf(resultSet.getString(4)) ;
//


                if(strdbPhone.matches(phonenumber) && resultSet.getString(3).matches(email)){
                    n= resultSet.getInt(1);
//                   System.out.println("=======LOGINTRUE======="+ n);
                    break;

                }
//                System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4));


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return n;
    }

    public User getUser(int n) {


        con = DBConnection.createDbConnection();
        String query = "select * from Users";
        User account = null;  // Initialize account to null

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){
                String strdbPhone = String.format("%f", resultSet.getDouble(4));

                if(resultSet.getInt(1)== n){
                    account = new Admin(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
//                   account = {int id:resultSet.getInt(1),resultSet.getString(2)}
//                    resultSet.getInt(1),resultSet.getString(2)
                    break;

                }
//                System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4));


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return account;
    }


    public void AddProduct(Product s) {
        con = DBConnection.createDbConnection();
        String query ="insert into Products values(?,?,?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,s.getId());
            pstm.setInt(2,s.getCat_id());
            pstm.setString(3,s.getName());
            pstm.setInt(4,s.getQty());
            pstm.setString(5,s.getPrice());
            pstm.setInt(6,s.getLikes());
            int cnt = pstm.executeUpdate();
//          System.out.println("------------------------------------");
            if(cnt!=0){
                System.out.println("Product Added successfully !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//    public void AddBook(Product book) {
//        books.add(book);
//        booknames.add(book.getName());
//        saveBooks();
//    }

    private void getUsers() {
//        String text1 = "";
//        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
//            String s1;
//            while ((s1 = br1.readLine()) !=null) {
//                text1 = text1 + s1;
//            }
//            br1.close();
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//
//        if (!text1.matches("") || !text1.isEmpty()) {
//            String[] a1 = text1.split("<NewUser/>");
//            for (String s : a1) {
//                String[] a2 = s.split("<N/>");
//                if (a2[3].matches("Admin")) {
//                    User user = new Admin(a2[0], a2[1], a2[2]);
//                    users.add(user);
//                    usernames.add(user.getName());
//                } else {
//                    User user = new NormalUser(a2[0], a2[1], a2[2]);
//                    users.add(user);
//                    usernames.add(user.getName());
//                }
//            }
//        }
    }

    private void saveUsers() {
        String text1 = "";
        for (User user : users) {
            text1 = text1 + user.toString()+"<NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(usersfile);
            pw.print(text1);
            pw.close();
        } catch  (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void saveBooks() {
//        String text1 = "";
//        for (Product book : books) {
//            text1 = text1 + book.toString2()+"<NewBook/>\n";
//        }
//        try {
//            PrintWriter pw = new PrintWriter(booksfile);
//            pw.print(text1);
//            pw.close();
//        } catch  (Exception e) {
//            System.err.println(e.toString());
//        }
//    }
//
//    private void getBooks() {
//        String text1 = "";
//        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(booksfile));
//            String s1;
//            while ((s1 = br1.readLine()) !=null) {
//                text1 = text1 + s1;
//            }
//            br1.close();
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//
//        if (!text1.matches("") || !text1.isEmpty()) {
//            String[] a1 = text1.split("<NewBook/>");
//            for (String s : a1) {
//                Product book = parseBook(s);
//                books.add(book);
//                booknames.add(book.getName());
//            }
//        }
    }

//    public Product parseBook(String s) {
//        String[] a = s.split("<N/>");
//        Product book = new Product();
//        book.setName(a[0]);
//        book.setAuthor(a[1]);
//        book.setPublisher(a[2]);
//        book.setAdress(a[3]);
//        book.setQty(Integer.parseInt(a[4]));
//        book.setPrice(Double.parseDouble(a[5]));
//        book.setBrwcopies(Integer.parseInt(a[6]));
//        return book;
//    }

    public ArrayList<Product> getAllBooks() {
        return books;
    }

    public int getProduct(String productname) {
        int i = -1;
//

        con = DBConnection.createDbConnection();
        String query = "select * from Products ";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){


//


                if( resultSet.getString(3).matches(productname)){
                    i= resultSet.getInt(1);
//
                    break;

                }
//                System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4));


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return i;

    }
    public int getProductId(int productId) {
        int i = -1;
//

        con = DBConnection.createDbConnection();
        String query = "select * from Products ";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){


//
                String strdbId =   String.valueOf( resultSet.getInt(1)) ;
                String prIdString = String.valueOf( productId) ;
//                String strdbPhone = String.format("%f", resultSet.getDouble(4));

                if( strdbId.matches(prIdString)){
                    i= resultSet.getInt(1);
//
                    break;

                }
//                System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4));


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return i;

    }



    public int getCartId(int productId) {
        int i = -1;
//

        con = DBConnection.createDbConnection();
        String query = "select * from ProductCart ";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){


//
                String strdbId =   String.valueOf( resultSet.getInt(1)) ;
                String prIdString = String.valueOf( productId) ;
//                String strdbPhone = String.format("%f", resultSet.getDouble(4));

                if( strdbId.matches(prIdString)){
                    i= resultSet.getInt(1);
//
                    break;

                }
//                System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4));


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return i;

    }

    public int getCategoryId(int categoryId) {
        int i = -1;

        con = DBConnection.createDbConnection();
        String query = "select * from Category";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){

                String strdbId =   String.valueOf( resultSet.getInt(1)) ;
                String prIdString = String.valueOf(categoryId) ;


                if( strdbId.matches(prIdString)){
                    i= resultSet.getInt(1);
//
                    break;

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return i;

    }



    public  void getProducts () {
        int i = -1;
//

        con = DBConnection.createDbConnection();
        String query = "select * from Products ";

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            System.out.println("=================BELOW ARE THE LIST OF PRODUCTS AND PRODUCT DETAILS==========================");
            System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID","CATEGORY_ID","NAME","QUANTITY","PRICE","LIKES");

            System.out.println("------------------------------------");
            while(resultSet.next()){


                System.out.format("%d\t%d\t%s\t%d\t%s\t%d\n",resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getInt(6));
                System.out.println("------------------------------------");


            }
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }






    }
    public Product getProductById(int id){
        con = DBConnection.createDbConnection();
        String query = "select * from Products where id="+id;
//        Product product= null;
        Product product = new Product();

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            System.out.println("=================BELOW THE PRODUCT DETAILS==========================");

            System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID","CATEGORY_ID","NAME","QUANTITY","PRICE","LIKES");


            while(resultSet.next()){
                System.out.format("%d\t%d\t%s\t%d\t%s\t%d\n",resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getInt(6));
//                product = new Product(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getInt(6));
                product.setId(resultSet.getInt(1));
                product.setCat_id(resultSet.getInt(2));
                product.setName(resultSet.getString(3));
                product.setQty(resultSet.getInt(4));
                product.setPrice(resultSet.getString(5));
                product.setLikes(resultSet.getInt(6));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;

    }


    public Product getBook(int i) {
        return books.get(i);
    }

    public void deleteBook(int i) {
        books.remove(i);
        booknames.remove(i);
        saveBooks();
    }

    public void deleteAllData() {
        if (usersfile.exists()) {
            try {
                usersfile.delete();
            } catch (Exception e) {}
        }
        if (booksfile.exists()) {
            try {
                booksfile.delete();
            } catch (Exception e) {}
        }
        if (ordersfile.exists()) {
            try {
                ordersfile.delete();
            } catch (Exception e) {}
        }
        if (borrowingsfile.exists()) {
            try {
                borrowingsfile.delete();
            } catch (Exception e) {}
        }
    }

//    public void addOrder(Order order, Product book, int bookindex) {
//        orders.add(order);
//        books.set(bookindex, book);
//        saveOrders();
//        saveBooks();
//    }
//
//    private void saveOrders() {
//        String text1 = "";
//        for (Order order : orders) {
//            text1 = text1 + order.toString2()+"<NewOrder/>\n";
//        }
//        try {
//            PrintWriter pw = new PrintWriter(ordersfile);
//            pw.print(text1);
//            pw.close();
//        } catch  (Exception e) {
//            System.err.println(e.toString());
//        }
//    }

//    private void getOrders() {
//        String text1 = "";
//        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(ordersfile));
//            String s1;
//            while ((s1 = br1.readLine()) !=null) {
//                text1 = text1 + s1;
//            }
//            br1.close();
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//
//        if (!text1.matches("") || !text1.isEmpty()) {
//            String[] a1 = text1.split("<NewOrder/>");
//            for (String s : a1) {
//                Order order = parseOrder(s);
//                orders.add(order);
//            }
//        }
//    }

    public boolean userExists(String name) {
        boolean f = false;

        con = DBConnection.createDbConnection();
        String query = "select * from Users";


        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            while(resultSet.next()){


                if(resultSet.getString(2).matches(name)){
                    f = true;

                    break;

                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return f;
    }

    private User getUserByName(String name) {
        User u = new NormalUser("");
        for (User user : users) {
            if (user.getName().matches(name)) {
                u = user;
                break;
            }
        }
        return u;
    }

    public void updateProduct(
          int id,
 int cat_id,
String name,
    int qty,
   String price,
 int likes) {
        con = DBConnection.createDbConnection();
      String query = "update Products  set category_id=?, name=?, qty=?, price=?, likes=? where id=?";

//        String query ="UPDATE Products \n" +
//                "SET name = ?, \n" +
//                "    category_id = ?, \n" +
//                "    qty = ?, \n" +
//                "    price = ?, \n" +
//                "    likes = ?\n" +
//                "WHERE id = ?";

        try{
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,cat_id);
            pstm.setString(2,name);
            pstm.setInt(3,qty);
            pstm.setString(4,price);
            pstm.setInt(5,likes);
            pstm.setInt(6,id);
            int cnt = pstm.executeUpdate();
            if(cnt != 0)
                System.out.println("Products Details updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void deleteProduct(int id) {
        con = DBConnection.createDbConnection();
        String query = "delete  from Products where id=?" ;
        try{
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,id);

            int cnt = pstm.executeUpdate();
            if(cnt != 0)
                System.out.println("Product deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void getProductsByCategory (int cat_id) {

        con = DBConnection.createDbConnection();
        String query = "select * from Products where category_id="+cat_id;

        try{
            Statement stmt = con.createStatement();
            ResultSet  resultSet= stmt.executeQuery(query);
            System.out.println("=================BELOW ARE THE LIST OF PRODUCTS AND PRODUCT DETAILS==========================");
            System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID","CATEGORY_ID","NAME","QUANTITY","PRICE","LIKES");

            System.out.println("------------------------------------");
            while(resultSet.next()){


                System.out.format("%d\t%d\t%s\t%d\t%s\t%d\n",resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getInt(6));
                System.out.println("------------------------------------");


            }
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }






    }
    public void AddProductToCart(int prodid) {
        con = DBConnection.createDbConnection();
        String query ="insert into ProductCart values(?,?,?,?,?,?,?)";

//        private  int id;
//        private int category_id;
//        private  int product_id;
//        private String name;
//        private int qty;
//        private String price;
//        private int likes;

//        getProductId(productId) != -1

        if(getProductId(prodid)!=-1){
            Product product = getProductById(prodid);
            try{
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1,product.getId());
                pstm.setInt(2,product.getCat_id());
                pstm.setInt(3,product.getId());
                pstm.setString(4,product.getName());
                pstm.setInt(5,product.getQty());
                pstm.setString(6,product.getPrice());
                pstm.setInt(7,product.getLikes());
                int cnt = pstm.executeUpdate();
//          System.out.println("------------------------------------");
                if(cnt!=0){
                    System.out.println("Product Added to cart successfully !!!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }




    }

    public void removeProductFromCart(int id) {
        con = DBConnection.createDbConnection();
        String query = "delete  from ProductCart where id=?" ;
        try{
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,id);

            int cnt = pstm.executeUpdate();
            if(cnt != 0)
                System.out.println("Product removed from cart successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



//    private Order parseOrder(String s) {
//        String[] a = s.split("<N/>");
//        Order order = new Order(books.get(getBook(a[0])), getUserByName(a[1]),
//                Double.parseDouble(a[2]), Integer.parseInt(a[3]));
//        return order;
//    }
//
//    public ArrayList<Order> getAllOrders() {
//        return orders;
//    }
//
//    private void saveBorrowings() {
//        String text1 = "";
//        for (Borrowing borrowing : borrowings) {
//            text1 = text1 + borrowing.toString2()+"<NewBorrowing/>\n";
//        }
//        try {
//            PrintWriter pw = new PrintWriter(borrowingsfile);
//            pw.print(text1);
//            pw.close();
//        } catch  (Exception e) {
//            System.err.println(e.toString());
//        }
//    }
//
//    private void getBorrowings() {
//        String text1 = "";
//        try {
//            BufferedReader br1 = new BufferedReader(new FileReader(borrowingsfile));
//            String s1;
//            while ((s1 = br1.readLine()) !=null) {
//                text1 = text1 + s1;
//            }
//            br1.close();
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//
//        if (!text1.matches("") || !text1.isEmpty()) {
//            String[] a1 = text1.split("<NewBorrowing/>");
//            for (String s : a1) {
//                Borrowing borrowing = parseBorrowing(s);
//                borrowings.add(borrowing);
//            }
//        }
//    }

//    private Borrowing parseBorrowing(String s) {
//        String[] a = s.split("<N/>");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate start = LocalDate.parse(a[0], formatter);
//        LocalDate finish = LocalDate.parse(a[1], formatter);
//        Product book = getBook(getBook(a[3]));
//        User user = getUserByName(a[4]);
//        Borrowing brw = new Borrowing(start, finish, book, user);
//        return brw;
//    }
//
//    public void borrowBook(Borrowing brw, Product book, int bookindex) {
//        borrowings.add(brw);
//        books.set(bookindex, book);
//        saveBorrowings();
//        saveBooks();
//    }
//
//    public ArrayList<Borrowing> getBrws() {
//        return borrowings;
//    }
//
//    public void returnBook(Borrowing b, Product book, int bookindex) {
//        borrowings.remove(b);
//        books.set(bookindex, book);
//        saveBorrowings();
//        saveBooks();
//    }
}
