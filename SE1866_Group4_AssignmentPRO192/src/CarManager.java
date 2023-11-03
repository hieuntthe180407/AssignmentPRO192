import java.lang.*;
import java.util.*;

public class CarManager {

   

    
    public static void main(String[] args) {
     String[] options= {"List all brands","Add a new brand", "Search a brand based on its ID","Update a brand", "Save brands to the file",
     "List all cars in ascending order of brand names","List cars based on a part of an input brand name","Add a car","Remove a car","Update a car","Save car to file", "Quit"};
       int choice =0;
        Scanner sc = new Scanner(System.in);
        BrandList brandList = new BrandList();
        brandList.loadFromFile("Brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("Cars.txt");
         boolean changed =false;
       do{
           
           choice = Menu.getChoice(options);
           switch(choice){
               case 1: brandList.listBrands();break;
               case 2: brandList.();break;
               case 3: 
                brandList.searchID();
                    break;
               case 4: brandList.(); break;
               case 5: brandList.saveToFile("brands.txt");changed= false; break;
               case 6:carList.listCars();break;
               case 7: carList.printBasedBrandName();break;
               case 8: carList.(); break;
               case 9: 
                 System.out.print("Enter car ID to remove: ");
                    String carID = sc.next();
                    if (carList.removeCar(carID)) {
                        System.out.println("Car removed successfully.");
                    }
                    break;
               case 10: carList.(); break;
               case 11:carList.saveToFile("cars.txt");break;
               case 12: break;
               
                       default: System.out.println("Bye");
           }
       }
       while (choice >0 && choice <options.length);
    }
        
        
    }
    