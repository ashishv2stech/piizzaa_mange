package abc.pizaa_manage_sys;


import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Manage_Order {

	Scanner sc = new Scanner(System.in);

	int order_id = 101, quantity, price, total_Price;
	String pizza_name;
	boolean flag = true;

	public Orders take_Order() {
		
		System.out.println("Enter Pizza Name");
		pizza_name=sc.next();
			
		System.out.println("Enter Quantity");
		quantity=sc.nextInt();
			
		System.out.println("Enter Price");
		price=sc.nextInt();
			
			
		total_Price=price*quantity;
			
		Orders place_Order=new Orders();
		place_Order.setOrder_id(order_id);
		place_Order.setPizza_name(pizza_name);
		place_Order.setQuantity(quantity);
		place_Order.setPrice(price);
		place_Order.setTotal_Price(total_Price);
		order_id++;
		
		return place_Order;
	}
	public void view_Order(ArrayList<Orders> al) {
		System.out.println("ID\tPizza Name\tQuantity\tPrice\tTotal Price");
		Iterator<Orders> itr=al.iterator();
		
		while(itr.hasNext()) {
			Orders ord=itr.next();
			System.out.println(ord.getOrder_id()+"\t\t"+ord.getPizza_name()+"\t"+ord.getQuantity()+
					"\t"+ord.getPrice()+"\t"+ord.getTotal_Price());
		}
	}

	public void delete_Order(ArrayList<Orders> al, int temp_order_id) {
		Iterator<Orders> itr=al.iterator();
		
		while(itr.hasNext()) {
				Orders ord=itr.next();
			if(temp_order_id==ord.getOrder_id()) {
				al.remove(ord);
				System.out.println(temp_order_id+" is deleted");
				flag=false;
			}
		}
		if(flag) {
			System.out.println("Entered order ID is no available");
		}
	}

	

	public void search_by_id(ArrayList<Orders> al, int temp_order_id) {
		Iterator<Orders> itr=al.iterator();
		System.out.println("ID\tPizza Name\tQuantity\tPrice\tTotal Price");
		
		while(itr.hasNext()) {
			Orders ord=itr.next();
			if(temp_order_id==ord.getOrder_id()) {
				System.out.println(ord.getOrder_id()+"\t"+ord.getPizza_name()+"\t"+ord.getQuantity()+
						"\t"+ord.getPrice()+"\t"+ord.getTotal_Price());
				flag=false;
			}
		}
		if(flag) {
			System.out.println("No Orders available with order id: "+temp_order_id);
		}
	}

	
	
	
	public void writer(ArrayList<Orders> al) throws IOException {
		String[] columns = { "Order_Id", "Pizza Name", "Quantity", "Price", "total price" };

	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("Orders");
	Row headerRow = sheet.createRow(0);
	for (int i = 0; i < columns.length; i++) {
		Cell cell = headerRow.createCell(i);
		cell.setCellValue(columns[i]);
	}

	int rowNum = 1;
	for (Orders pizza : al) {
		Row row = sheet.createRow(rowNum++);

		row.createCell(0).setCellValue(pizza.getOrder_id());

		row.createCell(1).setCellValue(pizza.getPizza_name());

		row.createCell(2).setCellValue(pizza.getQuantity());

		row.createCell(3).setCellValue(pizza.getPrice());

		row.createCell(4).setCellValue(pizza.getTotal_Price());
	}

	for (int i = 0; i < columns.length; i++) {
		sheet.autoSizeColumn(i);
	}

	FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
	workbook.write(fileOut);
	fileOut.close();
	workbook.close();}
		

}

	
	
	
	
	
	
	              
	
	
	
	
	


