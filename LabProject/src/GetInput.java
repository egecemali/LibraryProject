import java.util.Scanner;

public class GetInput {
    public static String getInput(String query) {
        Scanner input = new Scanner(System.in);
        System.out.println(query);
        String userInput = input.nextLine();
        return userInput;


    }
}
