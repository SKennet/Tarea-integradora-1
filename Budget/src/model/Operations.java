package model;

public class Operations{
	
   private final static int PAINTING=980000, ROUGH_CONSTRUCTION=1300000, SOFT_CONSTRUCTION=2600000; //Constant cost for each type of work. 
   
/**
*This method calculates the total to pay for: materials, delivery, and the work (rough work, soft work, and painting). <br>
*<b>pre: </b> the user needs to know the ubication of the property, the price and amount of the materials.<br>
*<b>post: </b> this method will sum all the costs to calculate the total cost.<br>
*@param ubication ubication != null ^^ (ubication>0 ^^ ubication<4)
*@param costMaterials, has to be filled with int values biggers than zero. []costMaterials != null ^^ []costMaterials>0
*@param amountToBuy, has to be filled with int values biggers than zero. []amountToBuy != null ^^ []amountToBuy>0
*@return int, this method returns the total to pay for all the materials, delivery, and the work (rough work, soft work, and painting).
*/

    public static int totalBuy(int [] costMaterials, int [] amountToBuy, int ubication){          //This method calculate the total cost.
      
	  int costMaterialsOperations = 0;
	  
	  for(int i= 0 ; i<amountToBuy.length ;i++){
	    costMaterialsOperations =  costMaterialsOperations + ((costMaterials[i]) * (amountToBuy[i]));
	  }

	  switch(ubication){
		case 1: if(costMaterialsOperations<80000){
			            ubication = 120000;
		           }
				else if(costMaterialsOperations>=80000 && costMaterialsOperations<300000){
					ubication = 28000;
				}
				else{
					ubication = 0;
				}
				break;

		case 2: if(costMaterialsOperations<80000){
			            ubication = 50000;
		           }
				else if(costMaterialsOperations>=80000 && costMaterialsOperations<300000){
					ubication = 0;
				}
				else{
					ubication = 0;
				}
				break;

		case 3: if(costMaterialsOperations<80000){
			            ubication = 120000;
		           }
				else if(costMaterialsOperations>=80000 && costMaterialsOperations<300000){
					ubication = 55000;
				}
				else{
					ubication = 0;
				}
				break;		
	  }
	  
	int totalCost = costMaterialsOperations + PAINTING + ROUGH_CONSTRUCTION + SOFT_CONSTRUCTION + ubication;
	  return totalCost;
    }

/**
*This method will evalue wich shop has the best prices for each material. <br>
*<b>pre: </b> the user needs to have filled the arrays before, know his ubication, and how many materials are in the list .<br>
*<b>post: </b> this method will decide which shop has the best prices for each material.<br>
*@param firstValue, has to be declarated, inicializated, and filled with int values biggers than zero. []firstValue != null ^^ []firstValue>0
*@param secondValue, has to be declarated, inicializated, and filled with int values biggers than zero. []secondValue != null ^^ []secondValue>0
*@param thirdValue, has to be declarated, inicializated, and filled with int values biggers than zero. []thirdValue != null ^^ []thirdValue>0
*@param material, has to be filled with the names. []material !="" ^^ []material !=null
*@param diferentMaterials has to be declarated and inicializated before. diferentMaterials>0
*@param ubication ubication != null ^^ (ubication>0 ^^ ubication<8)
*@param amountToBuy, has to be filled with int values biggers than zero. []amountToBuy != null ^^ []amountToBuy>0
*@return int[], this method returns an array with ints: first ones corresponds.
*/
	
    public static int [] showBestShop(int [] firstValue, int [] secondValue, int [] thirdValue, String [] material, int diferentMaterials, int ubication, int []amountToBuy){   //This method will evalue wich shop has the best prices for each material.

        int [] totalAndBestShop = new int[diferentMaterials+1];
        int totalForBestOptions =0;

		for(int i=0; i<diferentMaterials ; i++){
		if(firstValue[i]< secondValue[i] && firstValue[i]< thirdValue[i]){
			totalForBestOptions += firstValue[i] * amountToBuy[i];
			totalAndBestShop[i] = 1;
		}
		else if(secondValue[i]<firstValue[i] && secondValue[i]<thirdValue[i]){

			totalForBestOptions += secondValue[i] * amountToBuy[i];
			totalAndBestShop[i] = 2;
		}
		else if(thirdValue[i]<firstValue[i] && thirdValue[i]<secondValue[i]){
			totalForBestOptions += thirdValue [i] * amountToBuy[i];
			totalAndBestShop[i] = 3;
		}	
		else if(firstValue[i]== secondValue[i] && firstValue[i] == thirdValue[i]){

			totalForBestOptions += firstValue[i] * amountToBuy[i];
			totalAndBestShop[i] = 4;
		}
		else if(firstValue[i] != secondValue[i] && firstValue[i] == thirdValue[i]){

			totalForBestOptions += firstValue[i] * amountToBuy[i];
			totalAndBestShop[i] = 5;

	    }
		else if(firstValue[i]== secondValue[i] && firstValue[i] != thirdValue[i]){

			totalForBestOptions += firstValue[i] * amountToBuy[i];
			totalAndBestShop[i] = 6;
		}
		else if(thirdValue[i]== secondValue[i] && firstValue[i] != secondValue[i]){

		totalForBestOptions += thirdValue[i] * amountToBuy[i];
		totalAndBestShop[i] = 7;
		}
		}
		
		switch(ubication){
		case 1: if(totalForBestOptions<80000){
			            ubication = 120000;
		           }
				else if(totalForBestOptions>=80000 && totalForBestOptions<300000){
					ubication = 28000;
				}
				else{
					ubication = 0;
				}
				break;

		case 2: if(totalForBestOptions<80000){
			            ubication = 50000;
		           }
				else if(totalForBestOptions>=80000 && totalForBestOptions<300000){
					ubication = 0;
				}
				else{
					ubication = 0;
				}
				break;

		case 3: if(totalForBestOptions<80000){
			            ubication = 120000;
		           }
				else if(totalForBestOptions>=80000 && totalForBestOptions<300000){
					ubication = 55000;
				}
				else{
					ubication = 0;
				}
				break;		
	  }
	  
	  totalAndBestShop[diferentMaterials] = totalForBestOptions+ubication;	
	  
	  return totalAndBestShop;
	}
	 
}
