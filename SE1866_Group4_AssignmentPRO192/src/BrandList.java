import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList extends ArrayList<Brand>{
       
       
public BrandList() {
    super();
}
    
     
public boolean loadFromFile(String filename){
        
        File f = new File(filename);
           if (!f.exists()) return false;
           try {
               FileReader fr = new FileReader(f);
               BufferedReader bf = new BufferedReader(fr);
               String line;
               while ((line= bf.readLine())!= null){
                   line =line.trim();
                   if (line.length()>0){
                        StringTokenizer stk = new StringTokenizer (line, ",");
                        String brandID = stk.nextToken().trim();
                        String brandName = stk.nextToken().trim();
                         String soundBrand = stk.nextToken().trim();
                        double price = Double.parseDouble(stk.nextToken().trim());
                        Brand b = new Brand(brandID, brandName, soundBrand, price);
                        this.add(b);
                   }  
               }
               bf.close();
               fr.close();
           } 
           catch (Exception e) {System.out.println(e);
                   
                   }
           return true;
       }
       


public boolean saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename); 
            PrintWriter pw= new PrintWriter(fw);
            for (Brand b : this)pw.println(b); 
                 pw.close();
                 fw.close();
            }
            catch (Exception e) {
               System.out.println(e);
        }
        return true;
    }

    
      public Brand search(String brandID){
          brandID = Inputter.normalize(brandID).toUpperCase();
          for (Brand b:this)
               if (b.brandID.equals(brandID)) return b;
          return null;
      }
          
public void searchID() {
        if (this.isEmpty()) System.out.println("Empty list!");
         else{
             String brandID = Inputter.getNonBlankStr("brandID of searched brand: ");
             Brand b= search(brandID);
             if (b==null) System.out.println("Not found");
             else System.out.println("Found: " + b);
         }
        
}


public Brand getUserChoice(){
    
}
public void addBrand(){
    String ID = null, brandName, soundBrand;
        double price;
        boolean duplicated = false;
        do{
            duplicated = (search(ID) != null);
            if(duplicated) System.out.println("ID is duplicated");
        } while(duplicated);
        brandName = Inputter.getNonBlankStr("Input brand name: ");
        soundBrand = Inputter.getNonBlankStr("Input sound brand: ");
        price = Inputter.getIntGreater("Input product price: ", 0);
        Brand newB = new Brand(ID, brandName, soundBrand, price);
        this.add(newB);
        System.out.println("Added");
    }
    



public void updateBrand(){
    
}
public void listBrands(){
    
       
        if (this.isEmpty()) System.out.println("Empty list!");
          else{
              
              System.out.println("\nBrand list:");
              for (Brand b:this) System.out.println(b);
          }
        
      

}
}
