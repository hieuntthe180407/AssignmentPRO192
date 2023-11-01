import java.lang.*;
import java.util.*;

public class CarManager {

   

    
    public static void main(String[] args) {
     String[] options= {"List all brands","Add a new brand", "Search a brand based on its ID","Update a brand", "Save brands to the file",
     "List all cars in ascending order of brand names","List cars based on a part of an input brand name","Add a car","Remove a car","Update a car","Save car to file", "Quit"};
      Scanner sc = new Scanner(System.in);
        BrandList brandList = new BrandList();
        brandList.loadFromFile("brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("cars.txt");
       
       int choice =0;
 
       do{
           
           choice = Menu.getChoice(options);
           switch(choice){
               case 1: listb.listBrands();break;
               case 2: listb.(); break;
               case 3: listb.(); break;
               case 4: listb.(); break;
               case 5: listb.saveToFile("brands.txt"); break;
               case 6: list.listCars();break;
               case 7: list.printBasedBrandName();break;
               case 8: list.(); break;
               case 9: list.(); break;
               case 10: list.(); break;
               case 11: list.saveToFile("cars.txt");break;
               case 12: break;
               
               
               
                       default: System.out.println("Bye");
           }
       }
       while (choice >0 && choice <12);
    }
        
        
    }
    

