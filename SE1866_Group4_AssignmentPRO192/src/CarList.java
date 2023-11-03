import java.util.*;
import java.lang.*;
import java.io.*;
public class CarList extends ArrayList<Car> {
    private BrandList brandList;

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
                        
                        String color = stk.nextToken().trim();
                        String frameID = stk.nextToken().trim();
                        String engineID = stk.nextToken().trim();
                       
                        Brand brand = brandList.get(modCount);
                        
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
        try (FileWriter fw = new FileWriter(filename);
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

public void addCar(){
    String carID = "Input carID: ", color, frameID, engineID;
        Brand br = (Brand)Menu.ref_getChoice(brandList);
        boolean duplicated;
        boolean duplicated1;
        boolean duplicated2;
        String msg1 = "Input frameID F0000: ";
        String msg2 = "Input engineID E0000: ";
        String regEx1 = "F\\d{4}";
        String regEx2 = "E\\d{4}";
        do{
            duplicated = (searchcarID(carID) != null);
            if(duplicated) System.out.println("carID is duplicated");
        }while(duplicated);
        do{
            frameID = Inputter.getPatternStr(msg1, regEx1);
            duplicated1 = (searchFrame(frameID) != null);
            if(duplicated1&&!frameID.matches("F\\d{4}")) System.out.println("frameID is duplicated");
        }while(duplicated1);
        do{
            engineID = Inputter.getPatternStr(msg2, regEx2);            
            duplicated2 = (searchEngine(engineID) != null);           
            if(duplicated2&&!engineID.matches("E\\d{4}")) System.out.println("engineID is duplicated");
        }while(duplicated2);
        color = Inputter.getNonBlankStr("Input color: ");
        Car newC = new Car(carID, br, color, frameID, engineID);
        this.add(newC);
        System.out.println("Added");
    }

    

    private Object searchcarID(String carID) {
        return carID;
    }

   

public void printBasedBrandName (){
      if (this.isEmpty()) System.out.println("Empty list!");
          else{
              String name = Inputter.getNonBlankStr("Searched car name: ");
              name= Inputter.normalize(name).toUpperCase();
              System.out.println(name);
              int count=0;
              for (Car c:this)
                  if (c.brand.brandName.toUpperCase().indexOf(name)>=0){
                      System.out.println(c);
                      count++;
                  }
              if (count>0) System.out.println("FOund: "+ count + "car(s)");
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

public boolean updateCar(){
    
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
