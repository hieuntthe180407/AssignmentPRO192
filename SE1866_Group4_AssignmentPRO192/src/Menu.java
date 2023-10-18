
import java.util.*;
import java.lang.*;

public class Menu {
   int choice = 0;

    public Menu() {
    }
   
    public int int_getChoice() {
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("1.  List all brands");
            System.out.println("2.  Add a new brand");
            System.out.println("3.  Search a brand based on its ID");
            System.out.println("4.  Update a brand");
            System.out.println("5.  Save brands to the file, named brands.txt ");
            System.out.println("6.  List all cars in ascending order of brand names");
            System.out.println("7.  List cars based on a part of an input brand name");
            System.out.println("8.  Add a car");
            System.out.println("9.  Remove a car based on its ID");
            System.out.println("10. Update a car based on its ID");
            System.out.println("11. Save cars to file, named cars.txt");
            System.out.println("12. exit");
            System.out.print("input your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    
                    break;
                case 2:

                    
                    break;
                case 3:

                   
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                   
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                   
                    break;

            }

        } while (choice <= 11);
        return choice;
    }
    
    public Car ref_getChoice(){
        
        List<Car>  cars = new ArrayList<>();
        do{
            choice = Menu.this.int_getChoice();
            
        }
        while (choice<0 || choice>cars.size() );
        return ref_getChoice();
    }

}
