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
     File file = new File(filename);
    if (!file.exists()) {
        return false;
    }

    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(", ");
            if (parts.length == 5) {
                String carID = parts[0];
                String brandID = parts[1];
                String color = parts[2];
                String frameID = parts[3];
                String engineID = parts[4];
                int brandPos = brandList.searchID(brandID);
                if (brandPos != -1) {
                    Brand brand = brandList.get(brandPos);
                    Car car = new Car(carID, brand, color, frameID, engineID);
                    this.add(car);
                }
            }
        }
        return true;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return false;
    }
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
    for (int i = 0; i < carList.size(); i++) {
        if (carList.get(i).getCarID().equals(carID)) {
            return i;
        }
    }
    return -1;
}

public int searchFrame(String frameID) {
    for (int i = 0; i < carList.size(); i++) {
        if (carList.get(i).getFrameID().equals(frameID)) {
            return i;
        }
    }
    return -1;
}

public int searchEngine(String engineID) {
    for (int i = 0; i < carList.size(); i++) {
        if (carList.get(i).getEngineID().equals(engineID)) {
            return i;
        }
    }
    return -1;
}

public void addCar(){
    
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
        carList.remove(pos);
        return true;
    }
}

public boolean updateCar(){
    
}

public void listCars(){
        
    
    if (this.isEmpty()) System.out.println("Empty list!");
          else{
              Collections.sort(this);
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
