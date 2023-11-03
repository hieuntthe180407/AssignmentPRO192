

import java.util.*;
import java.lang.*;
public class Car implements Comparable<Car>{
String carID;
Brand brand;
String color;
String frameID;
String engineID;

   
 
    public Car() {
        
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

  public static Comparator comparator1 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Car p1 = (Car)o1;
                Car p2 = (Car)o2;
               return p1.brand.brandID.compareTo(p2.brand.brandID);
            } 

  };

    

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return carID + ", " + brand.brandID + ", " + color + ", " + frameID + ", " + engineID ;
    }
    
    



   
   

    @Override
    public int compareTo(Car c) {
        int d= this.brand.brandName.compareTo(c.brand.brandName);
        if (d!=0) return d;
        return this.carID.compareTo(c.carID); 
    }
}
