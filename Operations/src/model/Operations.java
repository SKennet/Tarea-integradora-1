package model;

public class Operations{
	
   private final static int painting=980000, roughConstruction=1300000, softConstruction=2600000; //constant cost for each type of work. 
   

    public static int totalBuy(int [] costMaterials, int [] amountToBuy){
      
	  int costMaterialsHomeCenter = 0;
	  
	  for(int i= 0 ; i<amountToBuy.length ;i++){
	    costMaterialsHomeCenter =  costMaterialsHomeCenter + ((costMaterials[i]) * (amountToBuy[i]));
	  }
	  
	  int totalCostForHomeCenter = costMaterialsHomeCenter + painting + roughConstruction + softConstruction;
	  return totalCostForHomeCenter;
    }
	
 /*	public static int totalOfBuyingAtFerreteriaDelCentro(int costMaterials, int [] amountToBuy){
	
      for(int i= 0 ; i<amountToBuy.length ;i++){
	    int costMaterialsFerreteria +=  amountToBuy[i];
	  }	
	  
	  int totalCostForFerreteriaDelCentro = costMaterials + painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelCentro;
    }
	
	public static int totalOfBuyingAtFerreteriaDelBarrio(int costMaterials, int [] amountToBuy){
	  
	  for(int i= 0 ; i<amountToBuy.length ;i++){
	    int costMaterials +=  amountToBuy[i];
	  }
	  
	  int totalCostForFerreteriaDelBarrio = costMaterials + painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelBarrio;
	}
*/    }

