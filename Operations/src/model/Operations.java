package model;

public class Operations{
	
   private final static int painting=980000, roughConstruction=1300000, softConstruction=2600000; //constant cost for each type of work. 
   

    public static int totalOfBuyingAtHomeCenter(int costMaterials){

	  int totalCostForHomeCenter = costMaterials + painting + roughConstruction + softConstruction;
	  return totalCostForHomeCenter;
    }
	
	public static int totalOfBuyingAtFerreteriaDelCentro(int costMaterials){
	
	  int totalCostForFerreteriaDelCentro = costMaterials + painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelCentro;
    }
	
	public static int totalOfBuyingAtFerreteriaDelBarrio(int costMaterials){
	
	  int totalCostForFerreteriaDelBarrio = costMaterials + painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelBarrio;
    }
}