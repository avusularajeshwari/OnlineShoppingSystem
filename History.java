package p1;

import java.util.Scanner;

class order{
	int orderId;
	String orderName;
	double price;
	String status;
	order next,prv;
	order(int orderId, String orderName, double price, String status)
	{
		this.orderId=orderId;
		this.orderName=orderName;
		this.price=price;
		this.status=status;
	}
}
class orderHistory{
	private static final int Count = 0;
	order Head,NewNode,Cnode,Delnode;
	void AddOrder( int id, String orderName,double price, String status)
	{
		NewNode=new order(id,orderName,price,status);
		if(Head==null)
		{
			Head=NewNode;
		}
		else {
			Cnode=Head;
			while(Cnode.next!=null)
			{
				Cnode=Cnode.next;
			}
			Cnode.next=NewNode;
		}
		
	}
	int CountNodes() {
	  int Count=0;
	  Cnode=Head;
	  while(Cnode!=null)
	  {
		Count++;
		Cnode=Cnode.next;
	  }
	return Count;
	}
	void DelBegin()
	{
		if(Head==null)
			System.out.print("Empty");
		else {
			Delnode=Head;
			Head=Head.next;
			Delnode.next=null;
			System.out.println("Order Item is deleted");
			Delnode=null;
		}	
	}
	void DelLast() {
		if(Head==null)
			System.out.print("Empty");
		else
		{
			Cnode=Head;
	        while(Cnode.next.next!=null)
	        {
	            Cnode=Cnode.next;
	        }

	        Delnode=Cnode.next;
	        Delnode.next=null;
	        System.out.println("Order Item is deleted");
			Delnode=null;
		}
	}
	void Delorder() {
		if(Head==null)
			System.out.print("Link is empty");
		else {
			int pos;
			Scanner SC=new Scanner(System.in);
			System.out.print("enter the OrderId: ");
			pos=SC.nextInt();
			if(pos<1||pos>CountNodes()) {
				System.out.print("ID is invalid!");	
			}
			else {
				if(pos==1)
					DelBegin();
				else if(pos==CountNodes())
					DelLast();
				else {
					Cnode=Head;
					for(int i=1;i<pos-1;i++)
						Cnode=Cnode.next;
					Delnode=Cnode.next;
					Cnode.next=Delnode.next;
					Delnode.next=null;
					System.out.println("Order Item is deleted");
					Delnode=null;
					}
			}
		}
	}
	void display()
	{
		if(Head==null)
			System.out.print("List is empty");
		else {
			Cnode=Head;
			while(Cnode!=null)
			{
				System.out.println("OrderId: "+ Cnode.orderId+" ");
				System.out.println("orderName: "+Cnode.orderName+"");
				System.out.println("price: "+Cnode.price+"");
				System.out.println("Status: "+Cnode.status);
				System.out.println();
				
				Cnode=Cnode.next;
			}
		}
	}
}

public class History {

	public static void main(String[] args) {
		orderHistory obj=new orderHistory();
		obj.AddOrder(101, "Shirt", 1500, "Delivered");
		obj.AddOrder(102,"Pants", 2000, "pending");
		obj.AddOrder(103, "Frocks", 550, "Delivered");
		String choice;
		do {
			System.out.println("ONLINE SHOPPING ORDER HISTORY");
			System.out.println("----------------------");
			System.out.print("1.AddOrder\n2.Display\n3.DelOrder");
		Scanner SC=new Scanner(System.in);
		System.out.println("\nEnter your option: ");
		int opt=SC.nextInt();
		switch(opt) {
		case 1:
			System.out.print("Enter ID: ");
            int id=SC.nextInt();
            SC.nextLine();

            System.out.print("Enter Name: ");
            String name=SC.nextLine();

            System.out.print("Enter Price: ");
            double price=SC.nextDouble();
            SC.nextLine();

            System.out.print("Enter Status: ");
            String status=SC.nextLine();

            obj.AddOrder(id,name,price,status);
            System.out.println("Added Successfully");
            break;
		case 2:
			obj.display();
			break;
		case 3:
			obj.Delorder();
			break;	
		}
		System.out.print("Enter Y/y to continue");
		choice=SC.next();
		}while(choice.equals("Y")||choice.equals("y"));
		if(choice!="Y" && choice!="y")
        	System.out.print("Exit!");
		
	}
}
