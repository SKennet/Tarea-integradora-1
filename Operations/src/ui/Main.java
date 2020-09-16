package ui;
import model.*;
import java.util.Scanner;

public class Main{
	
	

	
	public static void main(String args[]){		  
        
		Scanner input = new Scanner(System.in);  //Here´s the scanner.
		
		int arrayLenght = diferentMaterialsToBuy(input);
		String [] names2 = thingsToBuy(arrayLenght, input);
		
		int [] materialAmount = amountToBuy(input, names2, arrayLenght);
		costAtHomeCenter(arrayLenght, names2, input, materialAmount);
		costAtFerreteriaDelCentro(arrayLenght, names2,input, materialAmount);
		costAtFerreteriaDelBarrio(arrayLenght, names2,input, materialAmount);
		
	}
	
	public static int diferentMaterialsToBuy(Scanner input){
		System.out.println("¿Cuántos materiales diferentes se necesitan?");
 		int diferentMaterials = input.nextInt();
		input.nextLine();
		return diferentMaterials;
	}
	
	
	public static String[] thingsToBuy(int diferentMaterials, Scanner input){                    
		
		String [] materials = new String [diferentMaterials];
		int [] amountMaterials = new int [diferentMaterials];
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
	
	public static void costAtHomeCenter(int diferentMaterials, String [] materials, Scanner input, int [] amountToBuy){              //This will ask for the cost of buying the stuff at Home Center.
		
	  int totalCostAtHomeCenter = 0;
      int [] unitaryCostAtHomeCenter = new int [diferentMaterials];	  
	  
	  System.out.println();
	  
	  for(int i=0 ; i< diferentMaterials ; i++){

	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en Home Center.");
		unitaryCostAtHomeCenter [i] = input.nextInt();	
		
		input.nextLine();
	  }
	  System.out.println();
	  System.out.println("EL total si se compra en Home Center es de: " + Operations.totalBuy(unitaryCostAtHomeCenter, amountToBuy));
	  System.out.println();

    }


    public static void costAtFerreteriaDelCentro(int diferentMaterials, String [] materials, Scanner input, int [] amountToBuy){      //This will ask for the cost of buying the stuff at Ferretería del centro.
		
	  int totalCostAtFerreteriaDelCentro = 0;
      int [] unitaryCostAtFerreteriaDelCentro = new int [diferentMaterials];	  
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del centro.");
		unitaryCostAtFerreteriaDelCentro [i] = input.nextInt();
		input.nextLine();
	  }
	  System.out.println();
	  System.out.println("EL total si se compra en Ferretería del centro es de: " + Operations.totalBuy(unitaryCostAtFerreteriaDelCentro, amountToBuy));
	  System.out.println();
    }


    public static void costAtFerreteriaDelBarrio(int diferentMaterials, String [] materials, Scanner input, int [] amountToBuy){    //This will ask for the cost of buying the stuff at Ferretería del barrio.
		
	  int totalCostAtFerreteriaDelBarrio = 0;	
	  int [] unitaryCostAtFerreteriaDelBarrio = new int [diferentMaterials];
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del barrio.");
		unitaryCostAtFerreteriaDelBarrio [i] = input.nextInt();
	  }
	  System.out.println();
	  System.out.println("EL total si se compra en Ferretería del barrio es de: " + Operations.totalBuy(unitaryCostAtFerreteriaDelBarrio, amountToBuy));
	  System.out.println();
    }			
}