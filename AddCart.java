package p1;

import java.util.Scanner;

class StackLLnode {
    String data;
    StackLLnode next;
}


class StackLLoperations {
    StackLLnode Top;
    Scanner sc = new Scanner(System.in);

   
    boolean Isempty() {
        return Top == null;
    }

    
    void push() {
        StackLLnode newnode = new StackLLnode();
        System.out.print("Enter item to add to cart: ");
        newnode.data = sc.nextLine();
        newnode.next = Top;
        Top = newnode;
        System.out.println("Items added to cart!");
    }

   
    void pop() {
        if (Isempty()) {
            System.out.println("Cart is empty");
        } else {
            StackLLnode Delnode = Top;
            Top = Top.next;
            Delnode.next = null;
            System.out.println("Removed item: " + Delnode.data);
        }
    }

   
    void peek() {
        if (Isempty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Item in cart: " + Top.data);
        }
    }

   
    void display() {
        if (Isempty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in cart:");
            StackLLnode cnode = Top;
            while (cnode != null) {
                System.out.println("- " + cnode.data);
                cnode = cnode.next;
            }
        }
    }
}


public class AddCart {

	public static void main(String[] args) {
		StackLLoperations obj = new StackLLoperations();
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n--- Online Shopping Cart Menu ---");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove last item from cart");
            System.out.println("3. Display all cart items");
            System.out.print("Enter your option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    obj.push();
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.display();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.print("Enter Y/y to continue");
            choice=sc.next();
        }while(choice.equals("Y")||choice.equals("y"));
        if(choice!="Y" && choice!="y")
        	System.out.print("Exit!");
	}
}
