import java.util.Scanner;

public class NumberInput {
    NumberInput() {

    }

    int getNumberWithinRange(int min, int max) {
        int numberGotten = 0;

        boolean range = false;
        Scanner scantron = new Scanner(System.in);

        do // this loop checks if the input is a number or not
        {
            if (scantron.hasNextInt())
            {

                numberGotten = scantron.nextInt();
                numberGotten = java.lang.Math.abs(numberGotten);
                range = true;
            } else {
                range = false;
                scantron.next();
            }

            if (numberGotten < min || numberGotten > max) {
                System.out.println("Invalid input detected, please input a number between " + min + " and " + max + ":");
                range = false;
            }
        }while (!range);

        return numberGotten;
    }
}
