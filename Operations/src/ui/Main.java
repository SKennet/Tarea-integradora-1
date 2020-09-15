package ui;
import model.*;
import java.util.Scanner;

public class Main{
	
	Scanner input = new Scanner(System.in);  //Here´s the scanner.

	
	public static void main(String args[]){		  

        System.out.println("¿Cuántos elementos diferentes se necesitan?");
 		int diferentMaterials = input.nextInt();

		Main courierLocal = new Main();
		courierLocal.thigsToBuy();
		courierLocal.costAtHomeCenter();
		courierLocal.costAtFerreteriaDelCentro();
		courierLocal.costAtFerreteriaDelBarrio();
	}
	
	
	public void thigsToBuy(int diferentMaterials){
		
		String [] materials = new String [diferentMaterials];
		int [] amountMaterials = new int [diferentMaterials];
		int [] typeOfUse = new int [diferentMaterials];
		input.nextLine();
		
		for(int i=0 ; i< diferentMaterials ; i++){  //Here´s the loop to add materials. It will end when the user wants to.

		 System.out.println("Por favor ingrese el nombre del producto.");
		 materials[i]=input.nextLine();
		 System.out.println("¿Cuánta cantidad se necesita? (Ingrese solo el valor númerico).");
		 amountMaterials[i]=input.nextInt();
		 System.out.println("Si el uso del material es en: obra negra pulse 1; si es para pintura pulse 2; o si es para obra blanca ingrese 3.");
         typeOfUse[i]=input.nextInt();
         input.nextLine();
         	 
		}      
	}
	
	public int costAtHomeCenter(int diferentMaterials, String [] materials){              //This will ask for the cost of buying the stuff at Home Center.
		
	  int totalCostAtHomeCenter = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en Home Center.");
		totalCostAtHomeCenter += input.nextInt();
	  }
	  return totalCostAtHomeCenter;
    }


    public int costAtFerreteriaDelCentro(int diferentMaterials, String [] materials){      //This will ask for the cost of buying the stuff at Ferretería del centro.
		
	  int totalCostAtFerreteriaDelCentro = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del centro.");
		totalCostAtFerreteriaDelCentro += input.nextInt();
	  }
	  return totalCostAtFerreteriaDelCentro;
    }


    public int costAtFerreteriaDelBarrio(int diferentMaterials, String [] materials){    //This will ask for the cost of buying the stuff at Ferretería del barrio.
		
	  int totalCostAtFerreteriaDelBarrio = 0;	
	  for(int i=0 ; i< diferentMaterials ; i++){
	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en la ferretería del barrio.");
		totalCostAtFerreteriaDelBarrio += input.nextInt();
	  }
	  return totalCostAtFerreteriaDelBarrio;
    }			
}