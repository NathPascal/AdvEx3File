import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;
//3.1 : voir les commentaires : écriture dans un fichier(l.79) et ouverture du fichier(l.92)

public class Resto {
	
		static final Price[] starter = {
				new Price("Entrée : ", 0),
				new Price("Salade", 5),
				new Price("Soupe", 5),
				new Price ("Quiche", 5),
				new Price ("Aucune", 0)};
		
		static final Price[] dishes = {
				new Price("Plats : ", 0),
				new Price("Poulet", 10),
				new Price("Boeuf", 10),
				new Price("Poisson", 12),
				new Price("Végétarien", 8),
				new Price("Vegan", 8),
				new Price("Aucun", 0)};
		
		static final Price[] sideDishes = {
				new Price("Accompagnements : ", 0),
				new Price("Riz", 3),
				new Price("Pates", 3),
				new Price("Frites", 3),
				new Price("Légumes", 2),
				new Price("Aucun", 0)};
		
		static final Price[] drinks = {
				new Price("Boissons : ", 0),
				new Price("Eau plate", 2),
				new Price("Eau gazeuse", 3),
				new Price("Soda", 5),
				new Price("Vin", 12),
				new Price("Aucun", 0)};
		
		static final Price[] desserts = {
				new Price("Desserts : ", 0),
				new Price("Tarte maison", 5),
				new Price("Mousse au chocolat", 5),
				new Price("Tiramisu", 5),
				new Price("Aucun", 0)};	 
		 
		
		public static void main(String[] args) {		
			System.out.println("Bonjour, combien de menus souhaitez-vous ?");
			
			Scanner scan = new Scanner(System.in);
			int orderNumber = scan.nextInt();		
			ArrayList<String> order = new ArrayList<>();
			
			int totalPrice = 0;
			
			for(int i = 0 ; i < orderNumber ; i++) {
					Price starterMenu = getChoice(starter, scan);
					Price dishesMenu = getChoice(dishes, scan);
					Price sideDishesMenu = getChoice(sideDishes, scan);
					Price drinksMenu = getChoice(drinks, scan);
					Price dessertsMenu = getChoice(desserts, scan);
					
					totalPrice = starterMenu.priceItems + dishesMenu.priceItems + sideDishesMenu.priceItems 
							+ drinksMenu.priceItems + dessertsMenu.priceItems ;
					
					order.add("**** Résumé de la commande " + (i+1) + " ****");
					order.add(starterMenu.toString());	
					order.add(dishesMenu.toString());
					order.add(sideDishesMenu.toString());
					order.add(drinksMenu.toString());
					order.add(dessertsMenu.toString());
					order.add("");
					order.add("total: " + totalPrice);
					order.add("");
			}
			
			//écriture dans un fichier 
					
		     try {
		            BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"));
		            for (String item : order) {
		                writer.write(item);
		                writer.newLine();
		            }
		            writer.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		     
			// Ouverture du fichier
			try {
	            if (Desktop.isDesktopSupported()) {
	                File file = new File("order.txt");
	                Desktop.getDesktop().open(file);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
				scan.close();
		}
		
		public static Price getChoice(Price[] table, Scanner scan) {
			System.out.println("Que souhaitez-vous comme " + table[0]);
			for(int i = 1 ; i < table.length ; i++ ) {
				System.out.print("[" + i + " - " + table[i] + "]");
			}
			int choice = scan.nextInt();
			return table[choice];
			
			}
		
		}


