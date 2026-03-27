package p1;

import java.util.Scanner;

class items{
	int Id;
	String Name;
	double price;
	items next;
	items(int Id,String Name,double price){
		this.Id=Id;
		this.Name=Name;
		this.price=price;
	}
}
class Wishlistitems{
	items Front,Rear,NewNode,Cnode,delnode;
	void Enqueue(int Id,String Name,double price) {
		NewNode=new items(Id,Name,price);
		if(Front==null && Rear==null)
			Front=Rear=NewNode;
		else
		{
			Rear.next=NewNode;
			Rear=NewNode;
		}
		System.out.print("Item Added Successfully");	
	}
	void Dequeue()
	{
		if(Front==null&& Rear==null)
			System.out.print("List is empty");
		else
		{
			delnode=Front;
			Front=Front.next;
			if(Front==null)
				Rear=null;
			delnode.next=null;
			System.out.print("Removed items successfully");
			delnode=null;
		}
	}
	void display()
	{
		if(Front==null&& Rear==null)
			System.out.print("List is empty");
		else
		{
			Cnode=Front;
			while(Cnode!=null)
			{
				System.out.println("Id :"+Cnode.Id);
				System.out.println("Name :"+Cnode.Name);
				System.out.println("Price :"+Cnode.price);
				
				Cnode=Cnode.next;
			}
		}
	}	
}

public class Whishlist {

	public static void main(String[] args) {
		
		Wishlistitems obj=new Wishlistitems();
		Scanner SC=new Scanner(System.in);
		String Choice;
		int option;
		do {
			System.out.print("1.Additems\n2.Display\n3.Remove");
			System.out.println("\nEnter your Option: ");
			option=SC.nextInt();
			
			switch(option)
			{
			case 1:
				System.out.println("Enter Id:");
				int Id=SC.nextInt();
				
				System.out.println("Enter Name: ");
				String Name=SC.next();
				
				System.out.println("Enter Price: ");
				double price=SC.nextDouble();
				
				obj.Enqueue(Id, Name, price);
	            break;
			case 2:
				obj.display();
				break;
			case 3:
				obj.Dequeue();
				break;
			}
			
			System.out.print("\nEnter y/Y to continue");
			Choice=SC.next();
		}while(Choice.equals("Y")||Choice.equals("y"));
		if(Choice!="Y" && Choice!="y")
			System.out.print("Exit");
		

	}

}
