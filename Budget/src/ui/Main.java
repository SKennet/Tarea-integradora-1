package ui;
import model.*;
import java.util.Scanner;

public class Main{
	
/**
*This method calls the other methods of the program, saves some variables that the program needs to use constantly, and declare the Scanner. <br>
*<b>pre: </b> give the other methods all the parameters they need.<br>
*<b>post: </b> this method will make the program runs.<br>
*@param args[], this parameter must have args that the program understands. args!=null
*/	
	public static void main(String args[]){		  
        
		Scanner input = new Scanner(System.in);  //Here´s the scanner.
		
		int arrayLenght = diferentMaterialsToBuy(input);
		int ubicationValue = ubication(input);
		
		String [] names2 = thingsToBuy(arrayLenght, input);
		
		int [] materialAmount = amountToBuy(input, names2, arrayLenght);                                          //This line: save the amount per each material.

        int[] costAtHomeCenterArray = totalCost(arrayLenght, names2, input, materialAmount, "Home Center", ubicationValue);
        int [] costAtFerreteriaDelCentro = totalCost(arrayLenght, names2, input, materialAmount, "Ferretería del centro.", ubicationValue);
        int [] costAtFerreteriaDelBarrio = totalCost(arrayLenght, names2, input, materialAmount, "Ferretería del barrio.", ubicationValue);

		int [] totalAndBestShop = Operations.showBestShop(costAtHomeCenterArray, costAtFerreteriaDelCentro, costAtFerreteriaDelBarrio, 
		names2, arrayLenght, ubicationValue, materialAmount);
		showBestShopForMaterials(totalAndBestShop, names2, costAtHomeCenterArray, costAtFerreteriaDelCentro, costAtFerreteriaDelBarrio,arrayLenght);

		displayMaterialsByUse(names2, arrayLenght, input, totalAndBestShop);
		
	}

/**
*This asks the user how many materials are in the list. <br>
*<b>pre: </b>the user needs to have a list with materials, and type an int.<br>
*<b>post: </b>this method will let the program knows how many diferent materials are in the list.<br>
*@param input has to be declarated before.
*@return an int with the total of materials in the list.
*/	
	public static int diferentMaterialsToBuy(Scanner input){          //This method asks how many materials are in the list. I commented it because it can be made in the method main.
        System.out.println("");
		System.out.println("¿Cuántos materiales diferentes se necesitan?");
 		int diferentMaterials = input.nextInt();
		input.nextLine();
		System.out.println("");
		return diferentMaterials;
	}

/**
*This asks the user the ubication of the place. <br>
*<b>pre: </b> the user needs to have a list with materials, and type an int. <br>
*<b>post: </b> this method will let the program knows the ubication to calculate the delivery cost.<br>
*@param input has to be declarated before.
*@return an int with the ubication.
*/	
	
	public static int ubication(Scanner input){                       //This method asks the user the ubication for the delivery.
		System.out.println("Por favor ingrese su ubicación. Si el inmueble está en el norte dígite 1; si está en el centro dígite 2; y si está en el sur dígite 3.");
		int ubication = input.nextInt();
		input.nextLine();
		System.out.println("");
		return ubication;
	}
	
/**
*This asks the user the name of each material in the list. <br>
*<b>pre: </b> the user needs to have a list with all the materials.<br>
*<b>post: </b> this method will let the program knows the names of all the materials and use it later, and asks for them.<br>
*@param diferentMaterials has to be declarated and inicializated before.
*@param input has to be declarated before.
*@return an String array with the names of the materials : names[].
*/	
	
	public static String[] thingsToBuy(int diferentMaterials, Scanner input){     //This method returns an array with the names of all the materials to buy.               
		
		String [] materials = new String [diferentMaterials];
		int [] typeOfUse = new int [diferentMaterials];

		
		for(int i=0 ; i< diferentMaterials ; i++){ 

		 System.out.println("Por favor ingrese el nombre del " + (i+1)+" producto.");
		 materials[i]=input.nextLine();
		}
	
		return materials;
	}

/**
*This asks the user the amount to buy of each material in the list. <br>
*<b>pre: </b> the user needs to have a list with all the materials and their amount.<br>
*<b>post: </b> this method will let the program knows the amount of all the materials and use it later, and ask for the names of them.<br>
*@param input has to be declarated before.
*@param names has to be filled. names != null ^^ names!=""
*@param diferentMaterials has to be declarated and inicializated before.
*@return an int array with the names of the materials : amountToBuy[].
*/

	public static int [] amountToBuy(Scanner input, String [] names, int diferentMaterials){  //This method asks the user how many units of each material are requested.
		int [] amountToBuy = new int[diferentMaterials];
		
		for(int i= 0 ; i<diferentMaterials ; i++){
		    System.out.println("¿Cuántas unidades de " + names[i] + " necesita? (Ingrese solo el valor númerico).");
		    amountToBuy [i] = input.nextInt();
		}
		return amountToBuy;
	}
	
/**
*This asks the user the name of each material in the list. <br>
*<b>pre: </b> the user needs to have a list with all the materials.<br>
*<b>post: </b> this method will let the program knows the unitary cost to use it later.<br>
*@param diferentMaterials has to be declarated and inicializated before. diferentMaterials>0
*@param materials has to be filled. materials != null ^^ materials !=""
*@param input has to be declarated before. input !=null
*@param amountToBuy has to be declarated and inicializated with the amount to buy of all the materials.
*@param shopName has to be write in the program, because it's not a variable. shopName != ""
*@param deliveryCost has to be inicializated and declarated. deliveryCost != null 
*@return an int array with the unitary cost of the materials : unitaryCost[].
*/

	public static int[] totalCost(int diferentMaterials, String [] materials, Scanner input, int [] amountToBuy, String shopName, int deliveryCost){  //This will ask for the cost of buying the stuff at Home Center, and return the total.
		

      int [] unitaryCost = new int [diferentMaterials];	  
	  
	  System.out.println();
	  
	  for(int i=0 ; i< diferentMaterials ; i++){

	    System.out.println("Por favor ingrese el costo unitario de: " + materials[i] + " en " + shopName);
		unitaryCost [i] = input.nextInt();	
		
		input.nextLine();
	  }
	  System.out.println();
	  System.out.println("EL total (incluyendo mano de obra y domicilio) si se compra en " + shopName + " es de " + Operations.totalBuy(unitaryCost, amountToBuy, deliveryCost));
	  System.out.println();
	  
	  return unitaryCost;

    }

/**
*This method displays the materials that are going to be used in the process that the user choosed. <br>
*<b>pre: </b> The user has to call this method in the main method.<br>
*<b>post: </b> this method will let the user know wich materials are going to be used in the process he choosed.<br>
*@param names , names 2 has to be declarated and inicializated with all the names. []names2 !=null
*@param diferentMaterials has to be declarated and inicializated before. diferentMaterials>0
*@param input has to be declarated before. input !=null
*@param totalAndBestShop has to be filled. totalAndBestShop != null ^^ totalAndBestShop>0
*/

	public static void displayMaterialsByUse(String [] names, int diferentMaterials, Scanner input, int [] totalAndBestShop){    //This method show the materials by their use. The user can choose which one he want's to see.

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
		
		if(typeChoosed==typeOfUse[i]){
			System.out.println(names[i]);
		}		
	  }
	}

/**
*This method will show the user wich shop has the best prices for each material. <br>
*<b>pre: </b> the user needs to have a list with all the materials.<br>
*<b>post: </b> this method will let the program knows the unitary cost to use it later.<br>
*@param totalAndBestShop, this method must be filled before with values biggers than zero. [] totalAndBestShop > 0.
*@param material has to be filled.  material!=null ^^ material!=""
*@param firstValue, has to be declarated, inicializated, and filled with int values biggers than zero. []firstValue != null ^^ []firstValue>0
*@param secondValue, has to be declarated, inicializated, and filled with int values biggers than zero. []secondValue != null ^^ []secondValue>0
*@param thirdValue, has to be declarated, inicializated, and filled with int values biggers than zero. []thirdValue != null ^^ []thirdValue>0
*@param diferentMaterials has to be declarated and inicializated before. diferentMaterials>0
*/
	
	public static void showBestShopForMaterials(int [] totalAndBestShop, String [] material, int [] firstValue, int [] secondValue, int [] thirdValue, int diferentMaterials){
		for(int i=0; i<diferentMaterials ; i++){
			switch(totalAndBestShop[i]){
				case 1: System.out.println("El mejor lugar para comprar " + material[i]+ " es Home Center donde cuesta $" + firstValue[i]);
						break;
				
				case 2: System.out.println("EL mejor lugar para comprar " + material[i] + " es Ferretería del centro donde cuesta $" + secondValue[i]);
						break;
		
				case 3: System.out.println("EL mejor lugar para comprar " + material[i] + " es Ferretería del barrio donde cuesta $" + thirdValue[i]);
						break;
						
				case 4: System.out.println("En cualquiera de las tres tiendas " + material[i] + " costará lo mismo: $" + firstValue[i]);
						break;

				case 5: System.out.println("En Home center y Ferretería del barrio " + material[i] + " costará lo mismo: $" + firstValue[i]);
                        break;

				case 6: System.out.println("En Home center y Ferretería del centro " + material[i] + " costará lo mismo: $" + firstValue[i]);
				        break;

				case 7: System.out.println("En Ferretería del centro y Ferretería del barrio " + material[i] + " costará lo mismo: $" + thirdValue[i]);
				        break;
		    }
		}
		System.out.println("EL total a pagar de los materiales y domicilio es de: $" + totalAndBestShop[diferentMaterials]);
	}
}	