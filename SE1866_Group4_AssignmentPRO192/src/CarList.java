

import java.util.*;
import java.lang.*;
public class CarList extends Car{
       BrandList brandList;
       ArrayList car = new ArrayList();
public CarList(BrandList bList){
    
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
    Collections.sort(car);
   
    
    for ( int i=0; i<car.size(); i++)
        System.out.println(this.car.get(i));
}

}
