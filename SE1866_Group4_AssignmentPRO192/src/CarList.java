


import java.util.*;
import java.lang.*;
public class CarList  {
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
    
}

public int searchFrame (String fID){
    
}

public int searchEngine (String eID){
    
}

public void addCar(){
    
}

public void printBasedBrandName (){
    
}

public boolean removeCar(){
    
}

public boolean updateCar(){
    
}

public void listCars(){
        cars.sort(null);
    
    for ( int i=0; i<cars.size(); i++){
       c= cars.get(i);
        System.out.println(c.screenString());
}
}
}
