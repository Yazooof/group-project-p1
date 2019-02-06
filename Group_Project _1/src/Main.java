
import java.util.Scanner;

/**
 * Description: sample main output for the program
 *
 * @author Amadeus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String option = "";
        Scanner standardInput = new Scanner(System.in);
        System.out.println("would you like to start collection? 'yes' or 'no' ");
        option = standardInput.nextLine();
        // option 1 is to ask if the user wants to add onto the json file having it saved.
        if (option.equalsIgnoreCase("yes")) {
            while (option.equalsIgnoreCase("yes")) {
                JSONWriter writer = new JSONWriter();
                writer.writeToJSON();
                System.out.println("would you like to end data collection?");
                option = standardInput.nextLine();
                if (option.equalsIgnoreCase("yes")) {
                    break;
                }
            }
            String option2 = "";
            System.out.println("would you like to start data collection without saving?");
            option2 = standardInput.nextLine();
            // option2 is for if the user wants to enter in data without having it saved onto the JSON file.
            while (option2.equalsIgnoreCase("yes")) {
                JSONWriter writer = new JSONWriter();
                writer.writerInterface();
                System.out.println("Would you like to start collection?");
                option2 = standardInput.nextLine();
                if (option.equalsIgnoreCase("yes")) {
                    break;
                }
            }

        }

        // not sure if it's in the criteria but will be a great addition to output the file and display what is needed.
        System.out.println("would you like to read all the reading data?");
        option = standardInput.nextLine();
        if (option.equalsIgnoreCase("yes")) {
            JSONReader Jreader = new JSONReader();
            Jreader.display();
        }

        System.out.println("data collection is completed");

    }

}
