package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Product #%d data: %n", i+1);
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = in.next().charAt(0);
			
			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("Price: ");
			double price = in.nextDouble();
			
			if (op == 'i') {
			System.out.print("Custom fee: ");
			double customsFee = in.nextDouble();
			product.add(new ImportedProduct(name, price, customsFee));
			} 
			else if(op == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(in.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			} 
			else {
				product.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product x: product) {
			System.out.println(x.priceTag());
		}
		in.close();

	}

}
