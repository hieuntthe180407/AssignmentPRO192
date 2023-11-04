
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu<E> {
    private Scanner scanner;
    private String prompt;
    private List<String> options;
    private List<E> optionValues;

    public Menu() {
        scanner = new Scanner(System.in);
        options = new ArrayList<>();
        optionValues = new ArrayList<>();
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void addOption(String option, E optionValue) {
        options.add(option);
        optionValues.add(optionValue);
    }

    public int int_getChoice() {
        int choice = -1;
        while (choice < 0 || choice > options.size()) {
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + ": " + options.get(i));
            }
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        }
        return choice;
    }

    public E ref_getChoice() {
        int choice = int_getChoice();
        return optionValues.get(choice);
    }
   
    
    
}
