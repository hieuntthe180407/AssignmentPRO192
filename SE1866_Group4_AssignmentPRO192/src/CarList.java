


import java.util.*;
import java.lang.*;
public class CarList {
       BrandList brandList;
       List<Car>  cars;
       Car c;
public CarList(BrandList bList){
        this.cars = new ArrayList<>();
        
    
}

public boolean loadFromFile(String){
    
}

public boolean saveToFile(String){
    
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
