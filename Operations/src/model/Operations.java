package model;
import ui.*;

public class Operations{
	
   private final static int painting=980000, roughConstruction=1300000, softConstruction=2600000; //constant cost for each type of work. 
   
   public static void objetCreation(){
	Main courierToMain = new Main();
	
	int diferentMaterials = courierToMain.thingToBuy().diferentMaterials;
	String [] materials = courierToMain.thingsToBuy().materials;
   }
    public int totalOfBuyingAtHomeCenter(Main courierToMain){
	
	  int totalCostForHomeCenter = courierToMain.costAtHomeCenter(int null, String [] null)+ painting + roughConstruction + softConstruction;
	  return totalCostForHomeCenter;
    }
	
	public int totalOfBuyingAtFerreteriaDelCentro(Main courierToMain){
	
	  int totalCostForFerreteriaDelCentro = courierToMain.costAtFerreteriaDelCentro()+ painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelCentro;
    }
	
	public int totalOfBuyingAtFerreteriaDelBarrio(Main courierToMain){
	
	  int totalCostForFerreteriaDelBarrio = courierToMain.costAtFerreteriaDelBarrio()+ painting + roughConstruction + softConstruction;
	  return totalCostForFerreteriaDelBarrio;
    }
  

}