


import java.util.*;
import java.lang.*;
public class CarList {
       public static void main(String[] args) {
    BrandList brandList = new BrandList();
    CarList carList = new CarList(brandList);
    
    // Load cars from the file
    if (carList.loadFromFile("cars.txt")) {
        // List all cars
        System.out.println("List all cars");
        carList.listCars();
    } else {
        System.out.println("Failed to load cars from the file.");
    }
}
       BrandList brandList;
       List<Car>  cars;
       Car c;
public CarList(BrandList bList){
        this.cars = new ArrayList<>();
        
    
}

public boolean loadFromFile(String){
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
                    cars.add(car);
                }
            }
        }
        return true;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean saveToFile(String){
     try {
        PrintWriter writer = new PrintWriter(filename);
        for (Car car : cars) {
            String line = car.getCarID() + ", " + car.getBrand().getBrandID() + ", " +
                          car.getColor() + ", " + car.getFrameID() + ", " + car.getEngineID();
            writer.println(line);
        }
        writer.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

public int searchID (String ID){
    int N = this.size(); 
       for (int i = 0; i < N; i++) {
              if (this.get(i).carID.equals(carID)) {
        return i;
        }
    }
    return -1;
}

public int searchFrame (String fID){
    int N = this.size();
    for (int i = 0; i < N; i++) {
       if (this.get(i).getFrameID().equals(fID)) {
            return i;
        }
    }
    return -1;
}

public int searchEngine (String eID){
    int N = this.size();
    for (int i = 0; i < N; i++) {
    if (this.get(i).getEngineID().equals(eID)) {
        return i;
        }
    }
    return -1;
}

public void addCar(){
    
}

public void printBasedBrandName (){
    
}

public boolean removeCar(){
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
        Collections.sort(cars);
    
    for ( int i=0; i<cars.size(); i++){
       c= cars.get(i);
        System.out.println(c.screenString());
}
}

    
}
