import java.util.Scanner;
public class Operations{
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);  //Here´s the scanner.

		int painting=980000, roughConstruction=1300000, softConstruction=2600000; //ocnstant cost for each type of work. 
		boolean finished=false; //This variable will stop the cycles when user wants to.
        String productName=""; //This will save the name of the product.
        double requestedAmount=0; //This will save how many material you have to buy.
		int use=0, decision; //This will be used to ask for the material use. And the second one will change the boolean if its necessary.

		while(finished != true){  //Here´s the loop to add materials. It will end when the user wants to.

		 System.out.println("Por favor ingrese el nombre del producto.");
		 productName=input.nextLine();
		 System.out.println("¿Cuánta cantidad se necesita? (Ingrese solo el valor númerico).");
		 requestedAmount=input.nextDouble();
		 System.out.println("Si el uso del material es en: obra negra pulse 1; si es para pintura pulse 2; o si es para obra blanca ingrese 3.");
         use=input.nextInt();
		 System.out.println("Si este era el último producto ingrese 1; si desea agregar más pulse 2.");
		 decision=input.nextInt();
         input.nextLine();
		 if(decision==1){
			finished=true; 
		 }
		 else{
			finished=false; 
		 }
		}
        
        
        
	}
}