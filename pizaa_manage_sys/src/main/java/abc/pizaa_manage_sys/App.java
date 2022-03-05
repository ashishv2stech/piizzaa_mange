package abc.pizaa_manage_sys;

import java.io.IOException;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InvalidFormatException, IOException
    {
    	ArrayList<Orders> al=new ArrayList<Orders>();
		Scanner sc=new Scanner(System.in);
		Manage_Order ord=new Manage_Order();
		int ch,temp_order_id;
		
		
		do {
			System.out.println("*******PIZZA*******");
			System.out.println("1.Take Order \n2.View Order \n3.Delete Order \n4.Search Order as per Order_Number\n");
			System.out.println("*******PIZZA*******");
			System.out.println("Enter your Choice");
			ch=sc.nextInt();
			System.out.println("-------------------------");

			switch (ch) {
			case 1://Take Order
				Orders or=ord.take_Order();
				al.add(or);
				ord.writer(al);
				break;
				
			case 2://View Order
				ord.view_Order(al);
				break;
			
			case 3://Delete Order
				System.out.println("Enter the Order ID you want to delete");
				temp_order_id=sc.nextInt();
				ord.delete_Order(al,temp_order_id);
				ord.view_Order(al);
				break;
			
			case 4://Search Order as per date
				System.out.println("Enter Order ID you want to search");
				temp_order_id=sc.nextInt();
				ord.search_by_id(al,temp_order_id);
				break;
			case 0://exit
				System.out.println("Thank You!");
				System.exit(ch);
				break;
			
			default://Wrong Selection
				System.out.println("Select the correct option");
				break;
			}
		}
		while(ch>0);
    }
}
