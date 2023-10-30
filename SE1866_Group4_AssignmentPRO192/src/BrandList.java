import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList extends ArrayList<Brand>{
       private List<Brand> bList = new ArrayList<>();
       
public BrandList() {
}
    
     
public boolean loadFromFile(String filename){
     try {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found.");
            return false;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            String[] parts = line.split(", ");
            if (parts.length == 4) {
                String brandID = parts[0];
                    String brandInfo = parts[1];
                    String[] brandInfoParts = brandInfo.split(": ");
                    if (brandInfoParts.length == 2) {
                        String brandName = brandInfoParts[0];
                        String soundBrand = brandInfoParts[1];
                        double price = Double.parseDouble(parts[2]);
                        Brand brand = new Brand(brandID, brandName, soundBrand, price);
                        bList.add(brand);
                    }
                }
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
}


public boolean saveToFile(String filename ){
     try {
            FileWriter fileWriter = new FileWriter(filename);
            for (Brand brand : bList) {
                fileWriter.write(brand.getBrandID() + ", " + brand.getBrandName() + " (" + brand.getSoundBrand() + "): " + brand.getPrice() + "\n");
            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
}

     public int size() {
        return bList.size();
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
    
       if (this.isEmpty()) System.out.println("Empty list file!");
        else{
            try {
            File f2 =new File("brands.txt");
            FileReader fr = new FileReader(f2);
            BufferedReader br = new BufferedReader(fr);
            int lineNumber=1;
            String line="";
            while ((line =br.readLine())!= null){
                System.out.println( lineNumber + ":" + line);
                lineNumber++;
            }
            br.close();
            fr.close();
            System.out.println("End of File");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
      

}
}
