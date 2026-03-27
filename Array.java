package p1;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] productIDs = {101,102,103,104,105,106};
        String[] productNames = {"jeans","tops","pants","kurtis","leggins","baggyjeans"};
        double[] prices = {900,550,500,250,650,1000};
        int[] discounts = {5,2,25,20,10,15,11,50};

        String choice12;

        do {
        	
        	System.out.print("ONLINE SHOPPING SYSTEM");
        	System.out.print("\n-----------------------");

            System.out.println("\n1.Products Available\n2.Search\n3.Sort\n4.Wishlist\n5.Add Cart\n6.Order History");
            System.out.print("Enter your option: ");
            int option = sc.nextInt();
            boolean found = false;
            
            switch(option) {

                case 1:
                	System.out.println("--------- Product Details ---------");

                    for(int i=0;i<productIDs.length;i++) {

                        double finalPrice = prices[i] - (prices[i]*discounts[i]/100);

                        System.out.println("Product ID: " + productIDs[i]);
                        System.out.println("Product Name: " + productNames[i]);
                        System.out.println("Price: " + prices[i]);
                        System.out.println("Discount: " + discounts[i] + "%");
                        System.out.println("Final Price: " + finalPrice);
                        System.out.println("-----------------------------");
                    }
                    break;

                case 2:
                    System.out.println("Search the Product Name:");
                    String name = sc.next();

                    for(int i = 0; i < productNames.length; i++)
                    {
                        if(productNames[i].equalsIgnoreCase(name))
                        {
                            double finalPrice = prices[i] - (prices[i] * discounts[i] / 100);

                            System.out.println("Product ID: " + productIDs[i]);
                            System.out.println("Product Name: " + productNames[i]);
                            System.out.println("Price: " + prices[i]);
                            System.out.println("Discount: " + discounts[i] + "%");
                            System.out.println("Final Price: " + finalPrice);

                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Product Not found");
                    }
                break;
                case 3:

                    for(int i=0;i<prices.length-1;i++){
                        for(int j=0;j<prices.length-i-1;j++){

                            if(prices[j] > prices[j+1]){

                                double tempPrice = prices[j];
                                prices[j] = prices[j+1];
                                prices[j+1] = tempPrice;

                                String tempName = productNames[j];
                                productNames[j] = productNames[j+1];
                                productNames[j+1] = tempName;

                            }
                        }
                    }

                    System.out.println("Products  sorted by prices:");
                    for(int i=0;i<prices.length;i++){
                        System.out.println(productNames[i] + "\n Price: " + prices[i]);
                    }
                    System.out.print("\nProducts are Sorted with prices!");
                    break;
                case 4:
                	
                	Wishlistitems obj=new Wishlistitems();
                	String choice1;
                	do {
                	System.out.println("---------Wishlist---------");
                	System.out.print("1.Additems\n2.Display\n3.Remove");
                	System.out.println("\nEnter your choice");
                	int ch = sc.nextInt();

                    switch(ch)
                    {
                        case 1:
                            System.out.print("Enter Id: ");
                            int Id = sc.nextInt();

                            System.out.print("Enter Name: ");
                            String Name = sc.next();

                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();

                            obj.Enqueue(Id, Name, price);
                            break;
                        case 2:
                            obj.display();
                            break;

                        case 3:
                            obj.Dequeue();
                            break;

                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.print("\nEnter Y/y to continue");
                    choice1=sc.next();
                	}while(choice1.equals("Y")||choice1.equals("y"));
                	if(choice1!="y"&& choice1!="Y")
                		System.out.print("Exited from Wishlist");
                    break;
                case 5:
                	StackLLoperations obj1=new StackLLoperations();
                	Scanner SC=new Scanner(System.in);
                	String choice13;
                	do {
                	System.out.print("\n--------Add to Cart--------");
                	System.out.println("\n1.Add Items\n2.Display items\n3.Remove from cart");
                	System.out.print("\nEnter your option");
                	int C=SC.nextInt();
                	switch(C)
                	{
                	case 1:
                		obj1.push();
                		break;
                	case 2:
                		obj1.pop();
                		break;
                	case 3:
                		obj1.display();
                	 default:
                         System.out.println("Invalid choice");
                		break;
                	}	
                	System.out.print("\nEnter Y/y to continue");
                	choice13=SC.next();
                	}while(choice13.equals("Y")||choice13.equals("y"));
                	if(choice13!="y"&& choice13!="Y")
                		System.out.print("\nExited from Add to Cart");
                	
                	break;
                case 6:
                	orderHistory obj2=new orderHistory();
                	Scanner Sc=new Scanner(System.in);
                	String choice11;
                	do {
                	
                	System.out.print("--------Order History--------");
                	System.out.println("\n1.Add Items\n2.Display items\n3.Remove from cart");
                	System.out.print("\nEnter your option");
                	
                	int c=Sc.nextInt();
                	switch(c) {
                  case 1:
        			System.out.print("Enter ID: ");
                    int id=Sc.nextInt();
                    Sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name1=Sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price=Sc.nextDouble();
                    Sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status=Sc.nextLine();

                    obj2.AddOrder(id,name1,price,status);
                    System.out.println("\nAdded Successfully");
                    break;
        		case 2:
        			obj2.display();
        			break;
        		case 3:
        			obj2.Delorder();
        			break;	
        			
        		}
                	System.out.print("\nEnter Y/y to continue");
                	choice11=Sc.next();
                	}while(choice11.equals("Y")||choice11.equals("y"));
                	if(choice11!="y"&& choice11!="Y")
                		System.out.print("\nExited from Order History");
            break;   	
              
            }

            System.out.println("\n\nEnter Y/y to continue: ");
            choice12 = sc.next();
        } while(choice12.equalsIgnoreCase("y"));

        System.out.println("Exit");
    }
}