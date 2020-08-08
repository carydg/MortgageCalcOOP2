package ph.cary;

import java.util.Scanner;

public class Console {
    public static double input(String prompt, double min, double max) {
        var scanner = new Scanner(System.in);
        double value;

        while(true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if(value < min || value > max)
                System.out.println("Enter within " + min + " and " + max);
            else
                break;
        }
        return value;
    }
}
