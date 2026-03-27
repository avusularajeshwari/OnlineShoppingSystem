package p1;
import java.io.FileWriter;
import java.io.IOException;

class Product {
    int ProductId;
    String ProductName;
    double Price,discount,finalprice;

   
    Product(int id, String name, double price,double discount) {
        this.ProductId = id;
        this.ProductName = name;
        this.Price = price;
        this.discount=discount;
        this.finalprice=price-(price*discount/100);
    }
}

public class shopinglist {

    public static void main(String[] args) {


        Product[] A = new Product[3];

        A[0] = new Product(101, "Jeans", 999.99, 10.0);
        A[1] = new Product(102, "Tops", 499.50, 4.0);
        A[2] = new Product(103, "Shoes", 1499.00, 8.0);

        displayShoppingList(A);
    }


    public static void displayShoppingList(Product[] A) {
        try {
            FileWriter fw = new FileWriter("shoppinglist.txt");

            fw.write("===== Welcome to Online Shopping =====\n\n");

            for (int i = 0; i < A.length; i++) {
                fw.write("Product Id: " + A[i].ProductId + "\n");
                fw.write("Product Name: " + A[i].ProductName + "\n");
                fw.write("Price: " + A[i].Price + "\n");
                fw.write("Discount: "+A[i].discount+"\n");
                fw.write("Finalprice: "+A[i].finalprice+"\n");
                fw.write("-----------------------------\n");
            }

            fw.close();
            System.out.println("Saved successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}