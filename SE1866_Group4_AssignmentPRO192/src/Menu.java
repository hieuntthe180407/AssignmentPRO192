
import java.util.*;
import java.lang.*;


   public class Menu {
  

    public Menu() {
        
    }

   

    public static int getChoice (String[] ops){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<ops.length; i++){
            System.out.println("\n" + (i+1) + "-" +ops[i]);
        }
        System.out.println("\n Choose 1.." + ops.length + ": ");
        return Integer.parseInt(sc.nextLine());
    }

    
}
