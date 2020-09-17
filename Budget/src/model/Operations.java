package model;

public class Operations{
	
   private final static int painting=980000, roughConstruction=1300000, softConstruction=2600000; //constant cost for each type of work. 
   

    public static int totalBuy(int [] costMaterials, int [] amountToBuy){
      
	  int costMaterialsOperations = 0;
	  
	  for(int i= 0 ; i<amountToBuy.length ;i++){
	    costMaterialsOperations =  costMaterialsOperations + ((costMaterials[i]) * (amountToBuy[i]));
	  }
	  
	  int totalCost = costMaterialsOperations + painting + roughConstruction + softConstruction;
	  return totalCost;
    }
	
    public static void showBestShop(int [] firstValue, int [] secondValue, int [] thirdValue, String [] material, int diferentMaterials){

        int totalForBestOptions =0;

		for(int i=0; i<diferentMaterials ; i++){
		if(firstValue[i]< secondValue[i] && firstValue[i]< thirdValue[i]){
			System.out.println("El mejor lugar para comprar " + material[i]+ " es Home Center donde cuesta $" + firstValue[i]);
			totalForBestOptions += firstValue[i];
		}
		if(secondValue[i]<firstValue[i] && secondValue[i]<thirdValue[i]){

			System.out.println("EL mejor lugar para comprar " + material[i] + " es Ferretería del centro donde cuesta $" + secondValue[i]);
			totalForBestOptions += secondValue[i];
		}
		if(thirdValue[i]<firstValue[i] && thirdValue[i]<secondValue[i]){
			System.out.println("EL mejor lugar para comprar " + material[i] + " es Ferretería del barrio donde cuesta $" + thirdValue[i]);
			totalForBestOptions += thirdValue [i];
		}
	  }
	  System.out.println("Si se compran todos los materiales en la tienda con los precios más bajos" +
	  " el total (incluida mano de obra) es de: $" + (totalForBestOptions+ painting + roughConstruction + softConstruction));
	}
	
/*	public static void materialsUse(int diferentMaterials){
           
		int [] typeOfUse = new int[diferentMaterials]; 
        int [] materialsForRoughConstruction = new int[diferentMaterials];
        int [] materialsForSoftConstruction = new int[diferentMaterials];
        int [] materialsForPainting = new int[diferentMaterials];		

		for(int i= 0 ; i<diferentMaterials ; i++){
		 System.out.println("Por favor específique para qué se necesita " + materials[i] + ", si es para obra negra"
		 + "dígite 1; si es para obra blanca dígite 2; si es para pintar dígite 3." );
		 typeOfUse[i] = input.nextInt();         	 
		}
		
		for(int i=0 ; i<diferentMaterials ; i++){
			switch(typeOfUse[i]){
				case 1: 
			}
		}
		}
	} */
}
 

