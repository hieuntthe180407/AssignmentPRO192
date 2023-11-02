import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList extends ArrayList<Brand>{
       
       
public BrandList() {
    super();
}
    
     
public boolean loadFromFile(String filename){
     
        File file = new File(filename);
        if (!file.exists()) {
            
            return false;
        }
        try (Scanner scanner = new Scanner(file)){
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            String[] parts = line.split(", ");
            if (parts.length == 4) {
                   String brandID = parts[0];
                    String brandName = parts[1];
                    String soundBrand = parts[2];
                    double price = Double.parseDouble(parts[3]);

                    Brand brand = new Brand(brandID, brandName, soundBrand, price);
                    this.add(brand);
                }
            }
              return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


public boolean saveToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename); 
            PrintWriter pw= new PrintWriter(fw);
            for (Brand brand : this)pw.println(brand); 
                 pw.close();
                 fw.close();
            }
            catch (Exception e) {
               System.out.println(e);
        }
        return true;
    }

    
      
          
public int searchID (String ID){
    int N = this.size();
    for (int i = 0; i < N; i++) {
    if (this.get(i).getBrandID().equals(bID)) {
        return i;
        }
    }
    return -1;
}
public Brand getUserChoice(){
    
}
public void addBrand(){
    
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