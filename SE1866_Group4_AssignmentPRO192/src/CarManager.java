import java.lang.*;
import java.util.*;

public class CarManager {

    private static BrandList bList;

    
    public static void main(String[] args) {
     String[] options= {"List all brands","Add a new brand", "Search a brand based on its ID","Update a brand", "Save brands to the file",
     "List all cars in ascending order of brand names","List cars based on a part of an input brand name","Add a car","Remove a car","Update a car","Save car to file", "Quit"};
       int choice =0;
       CarList list = new CarList(bList);
       do{
           System.out.println("\nStudent managing program");
           choice = Menu.getChoice(options);
           switch(choice){
               case 1: list.listCars(); break;
               case 2: list.(); break;
               case 3: list.(); break;
               case 4: list.(); break;
               case 5: list.saveToFile("brands.txt"); break;
               case 6: list.(); break;
               case 7: list.(); break;
               case 8: list.(); break;
               case 9: list.(); break;
               case 10: list.(); break;
               case 11: list.saveToFile("cars.txt"); break;
              
               case 12: list.(); break;
               
               
               
                       default: System.out.println("Bye");
           }
       }
       while (choice >0 && choice <12);
    }
        
        
    }
    

