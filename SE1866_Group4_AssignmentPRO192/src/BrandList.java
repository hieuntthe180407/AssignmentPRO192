import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList extends ArrayList<Brand>{
       Scanner scanner = new Scanner(System.in);
        String brandID, brandName, soundBrand;
        private double price;
       
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

 public int searchId (String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }


public Brand getUserChoice(){
    Menu<Brand> menu = new Menu<>();
        menu.setPrompt("Choose a brand:");

        for (Brand brand : this) {
            menu.addOption(brand.getBrandName(), brand);
        }

        return menu.ref_getChoice();
}
public void addBrand(){
   
          int price;
          
        
          brandID= Inputter.getNonBlankStr("Input  brandID: ");
          brandName= Inputter.getNonBlankStr("Input  brandName: ");
          soundBrand= Inputter.getNonBlankStr("Input soundBrand: ");
          price = Inputter.getIntGreater("Input price", 0);
         
          Brand newP = new Brand(brandID, brandName, soundBrand, price);
          this.add (newP);
          System.out.println("Brand added.");
    }
    



 public void updateBrand () {
        do {
            
            int pos;
            
            System.out.print("Input brand ID: ");
            brandID = scanner.nextLine();
            pos = searchId (brandID);
            if (pos != -1) {
                break;
            }
            System.out.println("Not found !");
        } while (true);
        do {
            System.out.print("Input brand name: ");
            brandName = scanner.nextLine();
            if (brandName.equals("") != true) {
                break;
            }
            System.out.println("The brand name must not be null. Try again !");
        } while (true);
        do {
            System.out.print("Input sound brand: ");
            soundBrand = scanner.nextLine();
            if (soundBrand.equals("") != true) {
                break;
            }
            System.out.println("The sound brand must not be null. Try again !");
        } while (true);
        do {
            System.out.print("Input price: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("The price must not be null. Try again !");
                    price = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("The price must be a number. Try again !");
                price = 0;
            }
        } while (price == 0);
        this.get(0).setUpdatedBrand(brandName, soundBrand, price);
        System.out.println("Brand has updated successfully !");
 }
public void listBrands(){
    
       
        if (this.isEmpty()) System.out.println("Empty list!");
          else{
              
              System.out.println("\nBrand list:");
              for(Brand b:this) System.out.println(b);
          }
        
      

}
}
