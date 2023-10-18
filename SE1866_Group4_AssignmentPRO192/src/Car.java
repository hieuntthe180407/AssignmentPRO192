

import java.util.*;
import java.lang.*;
public class Car implements Comparable<Car>{
String carID;
Brand brand;
String color;
String frameID;
String engineID;

   
    List<Car> cars;
    public Car() {
        
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

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
        return "Car{" + "carID=" + carID + ", brand=" + brand + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID + '}';
    }
    
    

public String screenString(){
    String result = "";
     for (Car carss : cars) 
    result = cars.stream().map((car) -> "<" + car.getBrand().getBrandName() + ", \"\\n\", " +
            car.getCarID() + ", " + car.getColor() + ", " +
            car.getFrameID() + ", " + car.getEngineID() + ">\n").reduce(result, String::concat);
    return result;
}

    @Override
    public int compareTo(Car o) {
        return this.brand.getBrandName().compareTo(o.brand.getBrandName());
    }
}
