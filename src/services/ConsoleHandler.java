package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleHandler {
    public String getUserAction() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<String> possibleInputs = new ArrayList<>(Arrays.asList("a", "r", "s", "q"));

        System.out.println("What do you want to do?");
        do {
            promptUser();
            userInput = scanner.nextLine();
        } while (!possibleInputs.contains(userInput));
        return userInput;
    }

    private void promptUser(){
        System.out.println("------------------------------");
        System.out.println("Press 'a' to add new person.");
        System.out.println("Press 'r' to remove a person.");
        System.out.println("Press 's' to search a person.");
        System.out.println("Press 'q' to quit.");
        System.out.println("------------------------------");
        System.out.print("You input: ");
    }
}
