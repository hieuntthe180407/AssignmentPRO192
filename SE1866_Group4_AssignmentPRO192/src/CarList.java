import java.util.*;
import java.lang.*;
import java.io.*;
public class CarList extends ArrayList<Car> {
    private String color, engineID;
    private Brand brand;
    Menu menu = new Menu();
    Scanner scanner = new Scanner (System.in);
    BrandList brandList;
    public CarList() {
        super ();
    }
    
    
    public CarList(BrandList brandList) {
        this.brandList = brandList;
        

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
                        String carID = stk.nextToken().trim();
                         String brandID = stk.nextToken().trim();
                        String color = stk.nextToken().trim();
                      
                        String frameID = stk.nextToken().trim();
                        String engineID = stk.nextToken().trim();
                       
                       
                        Brand brand = new Brand(brandID);
                        
                        Car c = new Car (carID, brand, color, frameID, engineID);
                        this.add(c);
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
        try (
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw)) {
            for (Car car : this) pw.println(car);
               pw.close();
               fw.close();
           
        } catch (Exception e) {
               System.out.println(e);
        }
         return true;
    }

public int searchID(String carID) {
    for (int i = 0; i < this.size(); i++) {
        if (this.get(i).getCarID().equals(carID)) {
            return i;
        }
    }
    return -1;
}

public int searchFrame(String frameID) {
    for (int i = 0; i < this.size(); i++) {
        if (this.get(i).getFrameID().equals(frameID)) {
            return i;
        }
    }
    return -1;
}

public int searchEngine(String engineID) {
    for (int i = 0; i < this.size(); i++) {
        if (this.get(i).getEngineID().equals(engineID)) {
            return i;
        }
    }
    return -1;
}
 private int searchEngineID(String searchEngineID) {
        for (int i = 0; i < this.size(); i++) {
            if (searchEngineID.equals(this.get(i).getEngineID())) {
                return i;
            }
        }
        return -1;
    }



 public void addCar(String carID, String color, String frameID, String engineID) {
        Scanner scanner = new Scanner(System.in);

        // Create a menu for choosing a brand
       
        Brand brand = brandList.getUserChoice();

        Car newCar = new Car(carID, brand, color, frameID, engineID);

        if (this.contains(newCar)) {
            System.out.println("Car ID must be unique and not duplicated.");
            return;
        }

        // Check for frameID and engineID uniqueness
        if (checkFrameIDAndEngineIDUniqueness(frameID, engineID)) {
            System.out.println("Frame ID and Engine ID must be unique and in the format 'Fxxxx' and 'Exxxx'.");
           return;
        }

        this.add(newCar);
        
    }
 public Car search(String carID){
          carID = Inputter.normalize(carID).toUpperCase();
          for (Car c:this)
               if (c.carID.equals(carID)) return c;
          return null;
      }
   private int searchFrameID(String searchFrameID) {
        for (int i = 0; i < this.size(); i++) {
            if (searchFrameID.equals(this.get(i).getFrameID())) {
                return i;
            }
        }
        return -1;
    }
public boolean checkFrameIDAndEngineIDUniqueness(String frameID, String engineID) {
        for (Car car : this) {
            if (car.getFrameID().equals(frameID) && car.getEngineID().equals(engineID)) {
                return true;
            }
        }
        return false;
    }
    
    

public void printBasedBrandName (){
      if (this.isEmpty()) System.out.println("Empty list!");
          else{
              String name = Inputter.getNonBlankStr("Searched car name based on brand name: ");
              name= Inputter.normalize(name).toUpperCase();
              System.out.println(name);
              int count=0;
              for (Car c:this)
                  if (c.brand.brandName.toUpperCase().indexOf(name)>=0){
                      System.out.println(c);
                      count++;
                  }
              if (count>0) System.out.println("Found: "+ count + "car(s)");
              if (count == 0)
                  System.out.println("Not found");          }
}

public boolean removeCar(String removedID) {
    int pos = searchID(removedID);
    if (pos < 0) {
        System.out.println("Not found!");
        return false;
    } else {
        this.remove(pos);
        return true;
    }
}

 public boolean updateCar () {
        String frameID;
        int pos;
        String updatedID;
        System.out.print("Input car ID to updated: ");
        updatedID = scanner.nextLine();
        pos = searchID(updatedID);
        if (pos >= 0) {
            Brand brand = menu.ref_getChoice(brandList);
            
            do {
                System.out.print("Input color: ");
                color = scanner.nextLine();
                if (color.equals("") != true) {
                    break;
                }
                System.out.println("The color must not be null. Try again !");
            } while (true);
            do {
                System.out.print("Input frame ID: ");
                frameID = scanner.nextLine();
                if ((frameID.matches("F[0-9][0-9][0-9][0-9]")) && (searchFrameID(frameID) == -1)) {
                    break;
                }
                System.out.println("The frame ID must be in F0000 format and not be duplicated. Try again !");
            } while (true);
            do {
                System.out.print("Input engine ID: ");
                engineID = scanner.nextLine();
                if ((engineID.matches("E[0-9][0-9][0-9][0-9]")) && (searchEngineID(engineID) == -1)) {
                    break;
                }
                System.out.println("The engine ID must be in E0000 format and not be duplicated. Try again !");
            } while (true);
            this.get(pos).setUpdatedCar (brand, color, frameID, engineID);
            return true;
        } else {
            System.out.println("Car ID not existed !");
        }
        return false;
    }

public void listCars(){
        
    
    if (this.isEmpty()) System.out.println("Empty list!");
          else{
              Collections.sort(this, Car.comparator1);
              System.out.println("\nCar list:");
              for (Car c:this) System.out.println(c);
          }
        

}

    public String screenString(){
    String result = "";
     for (Car c : this) 
    result = this.stream().map((car) -> "<" + car.getBrand().getBrandName() + ", \"\\n\", " +
            car.getCarID() + ", " + car.getColor() + ", " +
            car.getFrameID() + ", " + car.getEngineID() + ">\n").reduce(result, String::concat);
    return result;
}
}
