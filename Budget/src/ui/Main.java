package ui;
import model.*;
import java.util.Scanner;

public class Main{
	
	

	
	public static void main(String args[]){		  
        
		Scanner input = new Scanner(System.in);  //Here´s the scanner.
		
		System.out.println("¿Cuántos materiales hay en la lista?");
		int arrayLenght = input.nextInt();
		input.nextLine();
		
		String [] names2 = thingsToBuy(arrayLenght, input);
		
		int [] materialAmount = amountToBuy(input, names2, arrayLenght);
		Operations.showBestShop(totalCost(arrayLenght, names2, input, materialAmount, "Home Center"),
        totalCost(arrayLenght, names2, input, materialAmount, "Ferretería del centro."),
		totalCost(arrayLenght, names2, input, materialAmount, "Ferretería del barrio."), names2, arrayLenght);
		displayMaterialsByUse(names2, arrayLenght, input);
		
	}
	
/*	public static int diferentMaterialsToBuy(Scanner input){          //This method asks how many materials are in the list. I commented it because it can be made in the method main.
		System.out.println("¿Cuántos materiales diferentes se necesitan?");
 		int diferentMaterials = input.nextInt();
		input.nextLine();
		return diferentMaterials;
	} */
	
	
	public static String[] thingsToBuy(int diferentMaterials, Scanner input){     //               
		
		String [] materials = new String [diferentMaterials];
		int [] typeOfUse = new int [diferentMaterials];

		
		for(int i=0 ; i< diferentMaterials ; i++){ 

		 System.out.println("Por favor ingrese el nombre del " + (i+1)+" producto.");
		 materials[i]=input.nextLine();
		}
	
		return materials;
	}
	public static int [] amountToBuy(Scanner input, String [] names, int diferentMaterials){
		int [] amountToBuy = new int[diferentMaterials];
		
		for(int i= 0 ; i<diferentMaterials ; i++){
		    System.out.println("¿Cuántas unidades de " + names[i] + " necesita? (Ingrese solo el valor númerico).");
		    amountToBuy [i] = input.nextInt();
		}
		return amountToBuy;
	}
	
	public static int[] totalCost(int diferentMaterials, String [] materials, Scanner input, int [] amountToBuy, String shopName){              //This will ask for the cost of buying the stuff at Home Center.
		

      int [] unitaryCost = new int [diferentMaterials];	  
	  
	  System.out.println();
	  
	  for(int i=0 ; i< diferentMaterials ; i++){

	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en " + shopName);
		unitaryCost [i] = input.nextInt();	
		
		input.nextLine();
	  }
	  System.out.println();
	  System.out.println("EL total si se compra en " + shopName + " es de " + Operations.totalBuy(unitaryCost, amountToBuy));
	  System.out.println();
	  
	  return unitaryCost;

    }
	public static void displayMaterialsByUse(String [] names, int diferentMaterials, Scanner input){

      int [] typeOfUse = new int [diferentMaterials];
	  
	  for(int i=0 ; i<diferentMaterials ; i++){
		System.out.println("Por favor ingrese para qué se usará " + names[i] + ". Si es para obra negra dígite 1; para obra blanca dígite 2; para pintura dígite 3" );
        typeOfUse[i] = input.nextInt();		
	  }
	  
	  System.out.println("Desea ver los materiales usados para: obra negra, dígite 1; obra blanca, dígite 2; pintar, dígite 3." );
	  int typeChoosed = input.nextInt();
	  switch(typeChoosed){
		case 1: System.out.println("Los materiales utilizados para obra negra son: ");
		        break;
		case 2: System.out.println("Los materiales utilizados para obra blanca son: ");
		        break;
		case 3: System.out.println("Los materiales utilizados para pintura son: ");
		        break;		
	  }
	  
	  for(int i=0 ; i<diferentMaterials ; i++){
		switch(typeChoosed){
			case 1: if(1 == typeOfUse[i]){
			    System.out.println(names[i]);
			}
			    break;
			
			case 2: if(2 == typeOfUse[i]){
				System.out.println(names[i]);
			}
				break;
			case 3: if(3 == typeOfUse[i]){
				System.out.println(names[i]);
			}
			    break;
		}  
	  }
	}
		
}