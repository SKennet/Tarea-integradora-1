package ui;
import model.*;
import java.util.Scanner;

public class Main{
	
	

	
	public static void main(String args[]){		  
        
		Scanner input = new Scanner(System.in);  //Here´s the scanner.
		
		int arrayLenght = diferentMaterialsToBuy(input);
		String [] names2 = thingsToBuy(arrayLenght, input);
		
		//thingsToBuy(arrayLenght, input);
		costAtHomeCenter(arrayLenght, names2, input);
		costAtFerreteriaDelCentro(arrayLenght, names2,input);
		costAtFerreteriaDelBarrio(arrayLenght, names2,input);
		
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
		 System.out.println("¿Cuánta cantidad se necesita? (Ingrese solo el valor númerico).");
		 amountMaterials[i]=input.nextInt();
		 System.out.println("Si el uso del material es en: obra negra pulse 1; si es para pintura pulse 2; o si es para obra blanca ingrese 3.");
         typeOfUse[i]=input.nextInt();
         input.nextLine();
         	 
		}
		return materials;
	}
	
	public static int costAtHomeCenter(int diferentMaterials, String [] materials, Scanner input){              //This will ask for the cost of buying the stuff at Home Center.
		
	  int totalCostAtHomeCenter = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en Home Center.");
		totalCostAtHomeCenter += input.nextInt();
		input.nextLine();
	  }
	  totalCostAtHomeCenter += Operations.totalOfBuyingAtHomeCenter(totalCostAtHomeCenter);
	  return totalCostAtHomeCenter;
    }


    public static int costAtFerreteriaDelCentro(int diferentMaterials, String [] materials, Scanner input){      //This will ask for the cost of buying the stuff at Ferretería del centro.
		
	  int totalCostAtFerreteriaDelCentro = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del centro.");
		totalCostAtFerreteriaDelCentro += input.nextInt();
		input.nextLine();
	  }
	  totalCostAtFerreteriaDelCentro += Operations.totalOfBuyingAtFerreteriaDelCentro(totalCostAtFerreteriaDelCentro);
	  return totalCostAtFerreteriaDelCentro;
    }


    public static int costAtFerreteriaDelBarrio(int diferentMaterials, String [] materials, Scanner input){    //This will ask for the cost of buying the stuff at Ferretería del barrio.
		
	  int totalCostAtFerreteriaDelBarrio = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del barrio.");
		totalCostAtFerreteriaDelBarrio += input.nextInt();
	  }
	  totalCostAtFerreteriaDelBarrio += Operations.totalOfBuyingAtFerreteriaDelBarrio(totalCostAtFerreteriaDelBarrio);
	  return totalCostAtFerreteriaDelBarrio;
    }			
}